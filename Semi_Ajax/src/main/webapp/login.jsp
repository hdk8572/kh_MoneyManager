<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Log In</h1>
	<form action="${pageContext.request.contextPath}/ajaxuser" method="post">
		<input type="text" name="mid" placeholder="아이디를 입력해주세요.">
		<br>
		<input type="password" name="mpwd" placeholder="비밀번호를 입력해주세요.">
		<br>
		<br>
		<input type="submit" value="로그인"> <input type="button" id="btn-join" value="회원가입">
	</form>
<script>
</script>
</body>
</html>