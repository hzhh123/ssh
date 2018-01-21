package com.hd.service.Impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hd.dao.BaseDao;
import com.hd.entity.Organization;
import com.hd.entity.Project;
import com.hd.entity.Resource;
import com.hd.entity.Role;
import com.hd.entity.RoleResource;
import com.hd.entity.User;
import com.hd.entity.UserRole;
import com.hd.entity.vo.Menu;
import com.hd.service.UserService;
import com.hd.util.PageInfo;
import com.hd.util.TreeNode;
import com.hd.util.TreeNodeUtil;

/**
 * Created by Administrator on 2016/4/2.
 */
@Service("userService")
public class UserServiceImpl implements UserService{
    @Autowired
    private BaseDao<User,Long> userDao;
    @Autowired
    private BaseDao<UserRole,Long> userRoleDao;
    @Autowired
    private BaseDao<RoleResource,Long>roleResourceDao;
    @Autowired
    private BaseDao<Resource,Long>resourceDao;
    @Autowired
    private BaseDao<Organization,Long>organizationDao;
    @Autowired
    private BaseDao<Project,Long>projectDao;
    @Autowired
    private BaseDao<Role,Long>roleDao;
    //保存用户
    public Serializable save(User user) {
    	user.setCreateTime(new Date());
        return userDao.save(user);
    }

    public User getUser(Long id) {
        String hql="select u from User u where u.id=?";
        return userDao.get(hql,id);
    }

    public User getUserById(Long id){
        return userDao.get(User.class,id);
    }

    public void delete(Long id) {
        userDao.delete(User.class,id);
    }
    
    @Override
	public void save(Set<User> users) {
		// TODO Auto-generated method stub
		 userDao.save(users);
	}

	@Override
	public void update(User user) {
		User u=getUser(user.getId());
		user.setCreateTime(u.getCreateTime());
		userDao.update(user);
	}

	@Override
	public User getUserByUsernameAndPassword(User user) {
		// TODO Auto-generated method stub
		String hql="from User where username=? and password=?";
		return userDao.get(hql, user.getUsername(),user.getPassword());
	}

	@Override
	public void saveUserRole(String roleList, Long userid) {
		String hql="from UserRole where userId=?";
		List<UserRole> urList=userRoleDao.find(hql, userid);
		List<Long>rList=new ArrayList<Long>();
		if(urList.size()>0) {
			for(UserRole ur:urList) {
				rList.add(ur.getRoleId());
			}
		}
		if(!roleList.equals("")) {
			if(!roleList.equals(rList.toString())) {
				userRoleDao.deleteBatch(urList);
				String[]rsList=roleList.split(",");
				for(String r:rsList) {
					UserRole o=new UserRole();
					o.setRoleId(Long.valueOf(r));
					o.setUserId(userid);
					userRoleDao.save(o);
				}
			}
		}
	}

	@Override
	public List<TreeNode> getResourceByUserid(Long userid,Integer resourceType) {
		List<TreeNode>nodes=new ArrayList<TreeNode>();
		List<Menu>menuList=new ArrayList<Menu>();
		String hql="from UserRole where userId=?";
		List<UserRole>urList=userRoleDao.find(hql,userid);
		List<RoleResource>rrList=new ArrayList<RoleResource>();
		Set<Resource>resSet=new HashSet<Resource>();
		if(urList.size()>0) {
			for(UserRole ur:urList) {
				hql="from RoleResource where roleId=?";
				rrList.addAll(roleResourceDao.find(hql, ur.getRoleId()));
			}
			if(rrList.size()>0) {
				for(RoleResource rr:rrList) {
					Resource res=new Resource();
					if(resourceType!=null) {
						hql="from Resource where id=? and resourceType=? order by seq";
						res=resourceDao.get(hql, rr.getResourceId(),resourceType);
					}else {
						res=resourceDao.get(Resource.class, rr.getResourceId());
					}
					resSet.add(res);
				}
			}
		}
		if(resSet.size()>0) {
			for (Resource resource : resSet) {
				Menu menu=new Menu();
				menu.setId(resource.getId().toString());
				menu.setIcon(resource.getIcon());
				menu.setUrl(resource.getUrl());
				menu.setIsHeader("");
				menu.setName(resource.getName());
				menu.setOrder(""+resource.getSeq());
				menu.setParentId(resource.getPid()==null?"0":resource.getPid().toString());
				menu.setLevel(resource.getLevel());
				menuList.add(menu);
			}
			nodes=TreeNodeUtil.toListNode(menuList);
			return TreeNodeUtil.tree(nodes, "0");
		}
		return null;
	}

	@Override
	public PageInfo findDataGrid(Integer page, Integer limit, String name,String organizationId,String phone) {
		PageInfo info=new PageInfo(page,limit);
		List<User>users=new ArrayList<User>();
		
		String hql="from User where 1=1";
		if(name!=null&&!name.equals("")) {
			hql+=" and name like '%"+name+"%'";
		}
		if(organizationId!=null&&!organizationId.equals("")) {
			Long orgid=Long.valueOf(organizationId);
			if(orgid!=1) {
			  hql+=" and organizationId="+orgid;
			}
		}
		if(phone!=null&&!phone.equals("")) {
				hql+=" and phone='"+phone+"'";
			
		}
			users=userDao.findPage(hql,page,limit);
			
			for(User user:users) {
				//设置部门
				if(user.getOrganizationId()!=null) {
					Organization org=organizationDao.get(Organization.class, user.getOrganizationId());
					user.setOrgName(org.getOrgname());
				}
				//设置项目
				if(user.getPjId()!=null) {
					Project project=projectDao.get(Project.class,user.getPjId());
					user.setProjectName(project.getName());
				}
				//设置直接上级
				if(user.getLeader()!=null) {
					User leaderUser=getUser(user.getLeader());
					user.setLeaderName(leaderUser.getName());
				}
				//设置角色
				String hql1="from UserRole where userId=?";
				List<UserRole>urList=userRoleDao.find(hql1,user.getId());
				String roleNameList="";
				if(urList.size()>0) {
					for(UserRole ur:urList) {
						Role role=roleDao.get(Role.class, ur.getRoleId());
						roleNameList+=role.getDescription()+",";
					}
					roleNameList=roleNameList.substring(0, roleNameList.length()-1);
					user.setRoleNameList(roleNameList);
				}
			}
			info.setData(users);
			int count=userDao.find(hql).size();
			info.setCount(count);
		return info;
	}

	@Override
	public void deleteBatch(String ids) {
		if(!ids.trim().equals("")) {
			List<Long>idList=new ArrayList<Long>();
			String[] ids_=ids.split(",");
			for(String id:ids_) {
				idList.add(Long.valueOf(id));
			}
			userDao.deleteBatch2(User.class,idList);
		}
		
		
	}

	@Override
	public List<Role> getRoles(Long id) {
		String hql1="from UserRole where userId=?";
		List<UserRole>urList=userRoleDao.find(hql1,id);
		List<Role>roles=new ArrayList<Role>();
		if(urList.size()>0) {
			for(UserRole ur:urList) {
				Role role=roleDao.get(Role.class, ur.getRoleId());
				roles.add(role);
			}
		}
		return roles;
	}

	@Override
	public List<User> findOfProject() {
		String hql="from User where pjId is not null";
		return userDao.find(hql);
	}

	
}
