<link href="${pageContext.request.contextPath }/resources/css/reset.css" rel="stylesheet">
<link href="${pageContext.request.contextPath }/resources/css/login.css" rel="stylesheet">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
</head>
<body>
	<div class="wrap-login">
		<div class="login">
			<h1>Login</h1>
		</div>
		<br>
		<div class="input-login">
			<form action="${pageContext.request.contextPath}/login.login" method="post">
				<input type="text" name="mid" placeholder="계정을 입력해주세요.">
				<br>
				<br>
				<input type="password" name="mpwd" placeholder="비밀번호를 입력해주세요.">
				<br>
				<br>
				<input type="button" id="btnJoin" value="회원가입"> <input type="submit" value="로그인">  
			</form>
		</div>
	</div>
<script>
	$("#btnJoin").click(joinClick);
	
	function joinClick() {
		window.location.href = "signup"
	}
</script>
</body>
</html>