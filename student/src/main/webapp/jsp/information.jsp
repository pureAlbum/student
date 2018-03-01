<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人信息管理</title>
</head>
<body>
	<div>
		<p style="text-align: center; font-size: 24px;">个人信息</p>
		<p style="text-align: center; font-size: 18px;">姓名：${user.name}</p>
		<p style="text-align: center; font-size: 18px;">性别：${user.sex}</p>
		<p style="text-align: center; font-size: 18px;">学号：${user.code}</p>
		<p id="classname" style="text-align: center; font-size: 18px;"></p>
		<p id="rolename" style="text-align: center; font-size: 18px;"></p>
	</div>
	<script type="text/javascript">
		$(function(){
			$("#rolename").load("/student/role/getname.do", {role: "${user.role}"});
			$("#classname").load("/student/class/getname.do", {id: "${user.classCode}"});
		})
	</script>
</body>
</html>