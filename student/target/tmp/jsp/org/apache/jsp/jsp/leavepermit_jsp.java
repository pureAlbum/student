/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: jetty/9.3.7.v20160115
 * Generated at: 2018-02-28 06:16:55 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class leavepermit_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

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
  }

  public void _jspDestroy() {
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
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<table class=\"easyui-datagrid\" id=\"dg3\"\r\n");
      out.write("\t\tdata-options=\"url:'/student/leave/selectbyclass.do',fitColumns:true,singleSelect:true\">\r\n");
      out.write("\t\t<!--id, user_code, why, time, begin_time, end_time, status-->\r\n");
      out.write("\t\t<thead>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th data-options=\"field:'id',width:100\">编码</th>\r\n");
      out.write("\t\t\t\t<th data-options=\"field:'user_code',width:100\">姓名</th>\r\n");
      out.write("\t\t\t\t<th data-options=\"field:'why',width:100\">原因</th>\r\n");
      out.write("\t\t\t\t<th data-options=\"field:'time',width:100\">日期</th>\r\n");
      out.write("\t\t\t\t<th data-options=\"field:'begin_time',width:100\">开始时间</th>\r\n");
      out.write("\t\t\t\t<th data-options=\"field:'end_time',width:100\">结束时间</th>\r\n");
      out.write("\t\t\t\t<th data-options=\"field:'status',width:100\">状态</th>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</thead>\r\n");
      out.write("\t</table>\r\n");
      out.write("\t<div id=\"tb2\">\r\n");
      out.write("\t\t<a href=\"#\" class=\"easyui-linkbutton\"\r\n");
      out.write("\t\t\tdata-options=\"iconCls:'icon-edit',plain:true\" onclick=\"update()\">更改状态</a>\r\n");
      out.write("\t\t<a href=\"#\" class=\"easyui-linkbutton\"\r\n");
      out.write("\t\t\tdata-options=\"iconCls:'icon-help',plain:true\"></a>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div id=\"win\" class=\"easyui-window\" title=\"修改信息\"\r\n");
      out.write("\t\tstyle=\"width: 600px; height: 400px\"\r\n");
      out.write("\t\tdata-options=\"modal:true,closed:true\">\r\n");
      out.write("\t\t<form id=\"ff\" method=\"post\">\r\n");
      out.write("\t\t\t<!-- \tid, name, sex, code, pass, classCode, role -->\r\n");
      out.write("\t\t\t<div style=\"width: 300px; margin: 20px;\">\r\n");
      out.write("\t\t\t\t<div style=\"float: right; margin: 6px;\">\r\n");
      out.write("\t\t\t\t\t<label for=\"status\">请假审批:</label> <select id=\"cc\"\r\n");
      out.write("\t\t\t\t\t\tclass=\"easyui-combobox\" name=\"status\" style=\"width: 200px;\">\r\n");
      out.write("\t\t\t\t\t\t<option value=\"批准\">批准</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"驳回\">驳回</option>\r\n");
      out.write("\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div style=\"clear: both;\"></div>\r\n");
      out.write("\t\t\t\t<a id=\"btn\" href=\"javascript:void(0)\" class=\"easyui-linkbutton\"\r\n");
      out.write("\t\t\t\t\tstyle=\"float: right; margin-right: 80px; padding: 0 20px;\">提交</a>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t$('#dg3').datagrid({\r\n");
      out.write("\t\t\ttoolbar : '#tb2'\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\tvar row=null;\r\n");
      out.write("\t\tfunction update(index) {\r\n");
      out.write("\t\t\trow = $('#dg3').datagrid('getSelected');\r\n");
      out.write("\t\t\t$('#win').window('open');\r\n");
      out.write("\t\t\t$('#btn').bind('click',{url:'/student/leave/updatestatus.do'},send);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction send(event){\r\n");
      out.write("\t\t\turl = event.data.url;\r\n");
      out.write("\t\t\t//\r\n");
      out.write("\t\t\t$('#ff').form({    \r\n");
      out.write("\t\t\t    url:url,    \r\n");
      out.write("\t\t\t    onSubmit:function(param){\r\n");
      out.write("\t\t\t    \tparam.id=row.id;\r\n");
      out.write("\t\t\t        // do some check    \r\n");
      out.write("\t\t\t        // return false to prevent submit;    \r\n");
      out.write("\t\t\t    },    \r\n");
      out.write("\t\t\t    success:function(data){\r\n");
      out.write("\t\t\t        $('#win').window('close');\r\n");
      out.write("\t\t\t        $('#dg3').datagrid('reload');\r\n");
      out.write("\t\t\t        $('#ff').form('clear');\r\n");
      out.write("\t\t\t        row=null;\r\n");
      out.write("\t\t\t    }    \r\n");
      out.write("\t\t\t});    \r\n");
      out.write("\t\t\t// submit the form    \r\n");
      out.write("\t\t\t$('#ff').submit();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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
}
