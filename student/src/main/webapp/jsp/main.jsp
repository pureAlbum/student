<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生信息管理系统</title>
<link rel="stylesheet" type="text/css"
	href="/student/easyui/themes/bootstrap/easyui.css">
<link rel="stylesheet" type="text/css"
	href="/student/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="/student/css/main.css">
<script type="text/javascript" src="/student/easyui/jquery.min.js"></script>
<script type="text/javascript"
	src="/student/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="/student/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" 
	src="/student/easyui/jquery.edatagrid.js"></script>
</head>
<body class="easyui-layout">
	<c:if test="${empty user}">
		<jsp:forward page="/jsp/index.jsp"></jsp:forward>
	</c:if>
	<div data-options="region:'north'" style="height: 150px;">
		<img alt="" src="/student/image/assiss.png" width="100%">
		<p class="title">Nothing is true,every is permitted.</p>
		<div class="sys">欢迎使用<span>[${user.name}]</span>|<span>[<a href="/student/user/exit.do">退出</a>]</span></div>
	</div>
	<div data-options="region:'south'" style="height: 200px;"></div>
	<div data-options="region:'west',title:'导航菜单',split:false"
		style="width: 300px;">
		<div id="aa" class="easyui-accordion">
<!-- 			<div title="系统" data-options="selected:true" -->
<!-- 			 style="overflow: auto; padding: 10px;"> -->
<!-- 				<a href="#" class="easyui-linkbutton"  -->
<!-- 					style="margin-bottom: 10px;" -->
<!-- 					data-options="width:'100%'">个人信息</a> -->
<!-- 				<a href="#" class="easyui-linkbutton" -->
<!-- 					style="margin-bottom: 10px;" -->
<!-- 					data-options="width:'100%'">班级管理</a> -->
<!-- 				<a href="#" class="easyui-linkbutton" -->
<!-- 					style="margin-bottom: 10px;" -->
<!-- 					data-options="width:'100%'">班级信息</a> -->
<!-- 			</div> -->
<!-- 			<div title="考勤" style="padding: 10px;">content2</div> -->
<!-- 			<div title="作业" style="padding: 10px;"> -->
<!-- 				<a id="btn2" href="#" class="easyui-linkbutton" -->
<!-- 					data-options="width:'100%'">easyui</a> -->
<!-- 			</div> -->
<!-- 			<div title="问卷" style="padding: 10px;"></div> -->
			<c:if test="${!empty roleper}">
				<c:forEach items="${roleper}" var="list">
				<c:if test="${list.pcode==0}">
					<div title="${list.permission_name}" style="padding: 10px;">
						<c:forEach items="${roleper}" var="list2">
							<c:if test="${list.menu_code==list2.pcode}">
								<a  class="easyui-linkbutton" 
									style="margin-bottom: 10px;"
									data-options="width:'100%'"
									onclick="javascript:tabup('${list2.permission_name}','${list2.url}')">
									${list2.permission_name}
								</a>
							</c:if>
						</c:forEach>
					</div>
				</c:if>
				</c:forEach>
			</c:if>
		</div>
	</div>
	<div data-options="region:'center'">
		<div id="tt" class="easyui-tabs" data-options="fit:true">
			<div title="首頁" style="padding: 20px; display: none;" 
			data-options="href:'/student/jsp/welcome.jsp'">
				
			</div>
		</div>
	</div>
	<script>
		function tabup(name,url){
			if ($("#tt").tabs("exists", name)) {
				$("#tt").tabs("select", name)
			} else {
				$('#tt').tabs('add', {
					title : name,
					selected : true,
					closable : true,
					href : url
				});
			}
		}
		
// 		$(function() {
// 			$('#btn2').bind('click', function() {
// 				if ($("#tt").tabs("exists", "tab")) {
// 					$("#tt").tabs("select", "tab")
// 				} else {
// 					$('#tt').tabs('add', {
// 						title : 'tab',
// 						selected : true,
// 						closable : true,
// 						href : "/student/jsp/index.jsp"
// 					});
// 				}
// 			});
// 		});
	</script>
</body>
</html>