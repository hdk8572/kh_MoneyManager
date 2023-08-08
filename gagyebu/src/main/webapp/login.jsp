<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 화면</title>
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
</head>
<body>
	<h1>Log In</h1>
	<form action="${pageContext.request.contextPath}/login.login" method="post">
		<input type="text" name="mid" placeholder="아이디를 입력해주세요.">
		<br>
		<input type="password" name="mpwd" placeholder="비밀번호를 입력해주세요.">
		<br>
		<br>
		<input type="submit" value="로그인"> <input type="button" id="btn-join" value="회원가입">
	</form>
<script>
	$("#btn-join").click(ajax1ClickHandler);
	function ajax1ClickHandler(result) {
		
	}

</script>
</body>
</html>
