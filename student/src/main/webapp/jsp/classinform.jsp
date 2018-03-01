<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<p style="text-align: center; font-size: 24px;">班级信息</p>
		<p style="text-align: center; font-size: 18px;">编号： ${user.classCode}</p>
		<p style="text-align: center; font-size: 18px;">班级： ${classinf.name}</p>
		<p style="text-align: center; font-size: 18px;">讲师： ${classinf.teacher}</p>
		<p style="text-align: center; font-size: 18px;">性别： ${classinf.sex}</p>
		<p style="text-align: center; font-size: 18px;">讲师id： ${classinf.code}</p>
	</div>
	<script type="text/javascript">
	</script>
</body>
</html>