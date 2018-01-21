package com.hd.test;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hd.entity.Icon;
import com.hd.entity.Project;
import com.hd.entity.User;
import com.hd.service.IconService;
import com.hd.service.OrganizationService;
import com.hd.service.ProjectService;
import com.hd.service.ResourceService;
import com.hd.service.RoleService;
import com.hd.service.UserService;
import com.hd.util.IconUtil;
import com.hd.util.JsonUtil;
import com.hd.util.PageInfo;
import com.hd.util.TreeNode;

/**
 * @author hzhh123
 * @time 2018年1月15日下午1:43:42
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml" })
public class Test {
	@Autowired
	private DataSource dataSource;
	@Autowired
	private RoleService roleService;
	@Autowired
	private UserService userService;
	@Autowired
	private OrganizationService organizationService;
	@Autowired
	private ResourceService resourceService;
	@Autowired
	private IconService iconService;
	@Autowired
	private ProjectService projectService;


	@org.junit.Test
	public void testDB() throws SQLException {
		System.out.println(dataSource.getConnection());
	}
	@org.junit.Test
	public void test2() {
		List<TreeNode>nodes=userService.getResourceByUserid(1L, 0);
		System.out.println(JsonUtil.toJson(nodes));
	}
	@org.junit.Test
	public void test3() {
		PageInfo info=userService.findDataGrid(1, 10, "李峰","","");
		System.out.println(JsonUtil.toJson(info));
	}
	@org.junit.Test
	public void test4() {
		String s="1";
		System.out.println(Long.valueOf(s));
	}
	@org.junit.Test
	public void test5() {
		String ids="4,5";
		userService.deleteBatch(ids);
	}
	
	@org.junit.Test
	public void test6() {
		organizationService.delete(2L);
	}
	@org.junit.Test
	public void test7() {
		PageInfo info=roleService.findDataGrid(1, 30);
		System.out.println(JsonUtil.toJson(info));
		
	}
	@org.junit.Test
	public void test8() {
		String result=resourceService.getTreeGrid();
		System.out.println(result);
	}
	 /**
     * 插入图标
     */
	@org.junit.Test
    public void test9(){
        //插入fontawesome
      
        String readPath=IconUtil.FONTAWESOME_PATH;
        List<String>slist= IconUtil.matchList(readPath,"fa");
        for(String s:slist){
            Icon icon=new Icon();
            icon.setSourcetype("fontawesome");
            icon.setDisplayname(s);
            icon.setClassname("fa "+s);
            iconService.save(icon);
        }
        /** 
        String readPath=IconUtil.GLYPHICON_PATH;
        List<String>slist= IconUtil.matchList(readPath,"glyphicon");
        for(String s:slist){
            Icon icon=new Icon();
            icon.setSourcetype("glyphicon");
            icon.setDisplayname(s);
            icon.setClassname("glyphicon "+s);
            iconService.save(icon);
        }**/
    }
	
	@org.junit.Test
	public void test10() {
		String str="12.png";
		System.out.println(str.substring(str.lastIndexOf('.')+1,str.length()));
	}
	@org.junit.Test
	public void test11() {
		List<Project>projects=projectService.findObjectByParams("润城九区",null);
		System.out.println(JsonUtil.toJson(projects));
	}
	@org.junit.Test
	public void test12() {
		List<User>users=userService.findOfProject();
		System.out.println(JsonUtil.toJson(users));
	}
}
