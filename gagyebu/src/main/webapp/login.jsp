<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 화면</title>
</head>
<body>
	<h1>Log In</h1>
	<form action="${pageContext.request.contextPath}/TODO">
		<input type="text" name="mid" placeholder="아이디를 입력해주세요.">
		<br>
		<input text="password" name="mpwd" placeholder="비밀번호를 입력해주세요.">
		<br>
		<input type="submit" value="로그인">
	</form>
</body>
</html>
