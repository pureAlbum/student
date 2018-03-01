<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
<link rel="stylesheet" type="text/css" href="/student/css/Login.css">
<script type="text/javascript" src="/student/js/jquery.js"></script>
<script type="text/javascript" src="/student/js/js.js"></script>
</head>
<body>
	<div class="body">

		<div class="lo-form">
			<h1>logining</h1>

			<form action="/student/user/login.do" method="post">
				<input name="code" type="text" placeholder="账户"> <input
					name="pass" type="password" placeholder="密码"> <input
					type="submit" value="登录" class="lo-sub"> <a
					onclick="wjmm()">忘记密码？</a>
			</form>
		</div>
	</div>
	<script type="text/javascript">
		function wjmm() {
			alert("那就忘了呗，我也很绝望啊")
		}
	</script>

</body>
</html>