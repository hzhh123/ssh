/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: jetty/9.3.10.v20160621
 * Generated at: 2018-01-19 09:21:13 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(6);
    _jspx_dependants.put("file:/D:/soft/maven/maven-repository/jstl/jstl/1.2/jstl-1.2.jar", Long.valueOf(1503026776757L));
    _jspx_dependants.put("/common/global.jsp", Long.valueOf(1515981530016L));
    _jspx_dependants.put("file:/D:/soft/maven/maven-repository/org/apache/taglibs/taglibs-standard-impl/1.2.5/taglibs-standard-impl-1.2.5.jar", Long.valueOf(1508288249604L));
    _jspx_dependants.put("jar:file:/D:/soft/maven/maven-repository/org/apache/taglibs/taglibs-standard-impl/1.2.5/taglibs-standard-impl-1.2.5.jar!/META-INF/fn.tld", Long.valueOf(1425949870000L));
    _jspx_dependants.put("jar:file:/D:/soft/maven/maven-repository/jstl/jstl/1.2/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153356282000L));
    _jspx_dependants.put("jar:file:/D:/soft/maven/maven-repository/jstl/jstl/1.2/jstl-1.2.jar!/META-INF/fmt.tld", Long.valueOf(1153356282000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      if (_jspx_meth_c_005fset_005f0(_jspx_page_context))
        return;
      if (_jspx_meth_c_005fset_005f1(_jspx_page_context))
        return;
      if (_jspx_meth_c_005fset_005f2(_jspx_page_context))
        return;
      out.write("<script type=\"text/javascript\">\n");
      out.write("    var basePath = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${staticPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\";\n");
      out.write("    window.UEDITOR_HOME_URL = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${staticPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/static/ueditor/\";\n");
      out.write("    window.UEDITOR_SERVER_URL = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${staticPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/ueditor\";\n");
      out.write("</script>");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\" />\r\n");
      out.write("    <meta charset=\"utf-8\" />\r\n");
      out.write("    <title>登陆页面</title>\r\n");
      out.write("\r\n");
      out.write("    <meta name=\"description\" content=\"用户登陆\" />\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0\" />\r\n");
      out.write("    <link  rel=\"shortcut icon\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/static/aceadmin/assets/favicon/favicon.ico\">\r\n");
      out.write("    <!-- bootstrap & fontawesome -->\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctxPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/static/aceadmin/assets/css/bootstrap.css\" />\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctxPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/static/aceadmin/assets/css/font-awesome.css\" />\r\n");
      out.write("\r\n");
      out.write("    <!-- text fonts -->\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctxPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/static/aceadmin/assets/css/ace-fonts.css\" />\r\n");
      out.write("\r\n");
      out.write("    <!-- ace styles -->\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctxPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/static/aceadmin/assets/css/ace.css\" />\r\n");
      out.write("\r\n");
      out.write("    <!--[if lte IE 9]>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctxPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/static/aceadmin/assets/css/ace-part2.css\" />\r\n");
      out.write("    <![endif]-->\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctxPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/static/aceadmin/assets/css/ace-rtl.css\" />\r\n");
      out.write("\r\n");
      out.write("    <!--[if lte IE 9]>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctxPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/static/aceadmin/assets/css/ace-ie.css\" />\r\n");
      out.write("    <![endif]-->\r\n");
      out.write("\r\n");
      out.write("    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->\r\n");
      out.write("\r\n");
      out.write("    <!--[if lt IE 9]>\r\n");
      out.write("    <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctxPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/static/aceadmin/assets/js/html5shiv.js\"></script>\r\n");
      out.write("    <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctxPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/static/aceadmin/assets/js/respond.js\"></script>\r\n");
      out.write("    <![endif]-->\r\n");
      out.write("    <style type=\"text/css\">\r\n");
      out.write("        @media(max-width: 768px) {\r\n");
      out.write("           .login-container{\r\n");
      out.write("               margin-top: 50px;\r\n");
      out.write("           }\r\n");
      out.write("\r\n");
      out.write("        }\r\n");
      out.write("    </style>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body class=\"login-layout light-login\">\r\n");
      out.write("<div class=\"main-container\">\r\n");
      out.write("    <div class=\"main-content\">\r\n");
      out.write("        <div class=\"row\">\r\n");
      out.write("            <div class=\"col-sm-10 col-sm-offset-1\">\r\n");
      out.write("                <div class=\"login-container\">\r\n");
      out.write("                    <div class=\"center\">\r\n");
      out.write("                        <h1>\r\n");
      out.write("                            <i class=\"ace-icon fa fa-leaf green\"></i>\r\n");
      out.write("                            <span class=\"red\">Ace</span>\r\n");
      out.write("                            <span class=\"white\" id=\"id-text2\">智慧工地</span>\r\n");
      out.write("                        </h1>\r\n");
      out.write("                        <h4 class=\"blue\" id=\"id-company-text\">&copy; 昆明昊蝶科技有限公司</h4>\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"space-6\"></div>\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"position-relative\">\r\n");
      out.write("                        <div id=\"login-box\" class=\"login-box visible widget-box no-border\">\r\n");
      out.write("                            <div class=\"widget-body\">\r\n");
      out.write("                                <div class=\"widget-main\">\r\n");
      out.write("                                    <h4 class=\"header blue lighter bigger\">\r\n");
      out.write("                                        <i class=\"ace-icon fa fa-coffee green\"></i>\r\n");
      out.write("                                        请输入你的登陆信息\r\n");
      out.write("                                    </h4>\r\n");
      out.write("\r\n");
      out.write("                                    <div class=\"space-6\"></div>\r\n");
      out.write("                                  <form action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctxPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/login/login!login\" method=\"post\" id=\"login\">\r\n");
      out.write("                                    <fieldset>\r\n");
      out.write("                                            <label class=\"block clearfix\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"block input-icon input-icon-right\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t <input type=\"text\" class=\"form-control\" id=\"username\" name=\"user.username\" placeholder=\"用户名\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<i class=\"ace-icon fa fa-user\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t</span>\r\n");
      out.write("                                            </label>\r\n");
      out.write("\r\n");
      out.write("                                            <label class=\"block clearfix\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"block input-icon input-icon-right\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  <input type=\"password\" class=\"form-control\" id=\"password\" placeholder=\"密码\" name=\"user.password\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<i class=\"ace-icon fa fa-lock\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t</span>\r\n");
      out.write("                                            </label>\r\n");
      out.write("\r\n");
      out.write("                                            <div class=\"space\"></div>\r\n");
      out.write("\r\n");
      out.write("                                            <div class=\"clearfix\">\r\n");
      out.write("\r\n");
      out.write("                                                <button type=\"button\" class=\"width-35 pull-right btn btn-sm btn-primary\" id=\"loginBtn\">\r\n");
      out.write("                                                    <i class=\"ace-icon fa fa-key\"></i>\r\n");
      out.write("                                                    <span class=\"bigger-110\">登陆</span>\r\n");
      out.write("                                                </button>\r\n");
      out.write("                                            </div>\r\n");
      out.write("\r\n");
      out.write("                                            <div class=\"space-4\"></div>\r\n");
      out.write("                                        </fieldset>\r\n");
      out.write("                                    </form>\r\n");
      out.write("                                </div><!-- /.widget-main -->\r\n");
      out.write("\r\n");
      out.write("                              <!--   <div class=\"toolbar clearfix\" style=\"height:30px;\">\r\n");
      out.write("                                </div -->\r\n");
      out.write("                            </div><!-- /.widget-body -->\r\n");
      out.write("                        </div><!-- /.login-box -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"navbar-fixed-top align-right\" id=\"bgsetter\">\r\n");
      out.write("                        <br />\r\n");
      out.write("                        &nbsp;\r\n");
      out.write("                        <a id=\"btn-login-dark\" href=\"#\">黑色</a>\r\n");
      out.write("                        &nbsp;\r\n");
      out.write("                        <span class=\"blue\">/</span>\r\n");
      out.write("                        &nbsp;\r\n");
      out.write("                        <a id=\"btn-login-blur\" href=\"#\">蓝色</a>\r\n");
      out.write("                        &nbsp;\r\n");
      out.write("                        <span class=\"blue\">/</span>\r\n");
      out.write("                        &nbsp;\r\n");
      out.write("                        <a id=\"btn-login-light\" href=\"#\">明亮</a>\r\n");
      out.write("                        &nbsp; &nbsp; &nbsp;\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div><!-- /.col -->\r\n");
      out.write("        </div><!-- /.row -->\r\n");
      out.write("    </div><!-- /.main-content -->\r\n");
      out.write("</div><!-- /.main-container -->\r\n");
      out.write("\r\n");
      out.write("<!-- basic scripts -->\r\n");
      out.write("\r\n");
      out.write("<!--[if !IE]> -->\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("    window.jQuery || document.write(\"<script src='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctxPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/static/aceadmin/assets/js/jquery.js'>\"+\"<\"+\"/script>\");\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<!-- <![endif]-->\r\n");
      out.write("\r\n");
      out.write("<!--[if IE]>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("    window.jQuery || document.write(\"<script src='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctxPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/static/aceadmin/assets/js/jquery1x.js'>\"+\"<\"+\"/script>\");\r\n");
      out.write("</script>\r\n");
      out.write("<![endif]-->\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("    if('ontouchstart' in document.documentElement) document.write(\"<script src='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctxPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/static/aceadmin/assets/js/jquery.mobile.custom.js'>\"+\"<\"+\"/script>\");\r\n");
      out.write("</script>\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${staticPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/static/plugin/layer/layer.js\"></script>\r\n");
      out.write("<!-- inline scripts related to this page -->\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("    jQuery(function($) {\r\n");
      out.write("        $(document).on('click', '.toolbar a[data-target]', function(e) {\r\n");
      out.write("            e.preventDefault();\r\n");
      out.write("            var target = $(this).data('target');\r\n");
      out.write("            $('.widget-box.visible').removeClass('visible');//hide others\r\n");
      out.write("            $(target).addClass('visible');//show target\r\n");
      out.write("        });\r\n");
      out.write("    });\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    //you don't need this, just used for changing background\r\n");
      out.write("    jQuery(function($) {\r\n");
      out.write("        $('#btn-login-dark').on('click', function(e) {\r\n");
      out.write("            $('body').attr('class', 'login-layout');\r\n");
      out.write("            $('#id-text2').attr('class', 'white');\r\n");
      out.write("            $('#id-company-text').attr('class', 'blue');\r\n");
      out.write("\r\n");
      out.write("            e.preventDefault();\r\n");
      out.write("        });\r\n");
      out.write("        $('#btn-login-light').on('click', function(e) {\r\n");
      out.write("            $('body').attr('class', 'login-layout light-login');\r\n");
      out.write("            $('#id-text2').attr('class', 'grey');\r\n");
      out.write("            $('#id-company-text').attr('class', 'blue');\r\n");
      out.write("\r\n");
      out.write("            e.preventDefault();\r\n");
      out.write("        });\r\n");
      out.write("        $('#btn-login-blur').on('click', function(e) {\r\n");
      out.write("            $('body').attr('class', 'login-layout blur-login');\r\n");
      out.write("            $('#id-text2').attr('class', 'white');\r\n");
      out.write("            $('#id-company-text').attr('class', 'light-blue');\r\n");
      out.write("\r\n");
      out.write("            e.preventDefault();\r\n");
      out.write("        });\r\n");
      out.write("        $('#loginBtn').bind('click',login);\r\n");
      out.write("        $(document).keypress(function(event){\r\n");
      out.write("            if(event.keyCode==13){\r\n");
      out.write("                event.returnValue=false;\r\n");
      out.write("                event.cancel = true;\r\n");
      out.write("                login();\r\n");
      out.write("            }\r\n");
      out.write("        });\r\n");
      out.write("    });\r\n");
      out.write("    function login(){\r\n");
      out.write("    \t $.ajax({\r\n");
      out.write(" \t\t\turl:$('#login').attr('action'),\r\n");
      out.write(" \t\t\tdata:$('#login').serialize(),\r\n");
      out.write(" \t\t\ttype:'post',\r\n");
      out.write(" \t\t\tdataType:'json',\r\n");
      out.write(" \t\t\tsuccess:function(data){\r\n");
      out.write(" \t\t\t\tdata=eval('('+data+')');\r\n");
      out.write(" \t\t\t\tif(data.message=='success'){\r\n");
      out.write(" \t\t\t\t    layer.msg(\"登陆成功！\");\r\n");
      out.write(" \t\t\t\t\twindow.location.href=\"/login/login!index\";\r\n");
      out.write(" \t\t\t\t}else{\r\n");
      out.write(" \t\t\t\t    layer.msg(\"用户名或密码不对！\");\r\n");
      out.write(" \t \t\t\t}\r\n");
      out.write(" \t\t\t}\r\n");
      out.write("    \t });\r\n");
      out.write("    }\r\n");
      out.write("</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fset_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f0.setParent(null);
    // /common/global.jsp(6,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setVar("ctxPath");
    // /common/global.jsp(6,0) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setValue(new org.apache.jasper.el.JspValueExpression("/common/global.jsp(6,0) '${pageContext.request.contextPath}'",_jsp_getExpressionFactory().createValueExpression(_jspx_page_context.getELContext(),"${pageContext.request.contextPath}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    int _jspx_eval_c_005fset_005f0 = _jspx_th_c_005fset_005f0.doStartTag();
    if (_jspx_th_c_005fset_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f1 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f1.setParent(null);
    // /common/global.jsp(7,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f1.setVar("path");
    // /common/global.jsp(7,0) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f1.setValue(new org.apache.jasper.el.JspValueExpression("/common/global.jsp(7,0) '${ctxPath}'",_jsp_getExpressionFactory().createValueExpression(_jspx_page_context.getELContext(),"${ctxPath}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    int _jspx_eval_c_005fset_005f1 = _jspx_th_c_005fset_005f1.doStartTag();
    if (_jspx_th_c_005fset_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f1);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f2(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f2 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f2.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f2.setParent(null);
    // /common/global.jsp(8,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f2.setVar("staticPath");
    // /common/global.jsp(8,0) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f2.setValue(new org.apache.jasper.el.JspValueExpression("/common/global.jsp(8,0) '${ctxPath}'",_jsp_getExpressionFactory().createValueExpression(_jspx_page_context.getELContext(),"${ctxPath}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    int _jspx_eval_c_005fset_005f2 = _jspx_th_c_005fset_005f2.doStartTag();
    if (_jspx_th_c_005fset_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f2);
    return false;
  }
}