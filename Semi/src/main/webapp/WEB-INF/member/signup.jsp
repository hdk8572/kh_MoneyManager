<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
</head>
<body>
	<h1>회원가입</h1>
	
	<form action="${pageContext.request.contextPath}/signup" method="post">
		<table>
			<tr>
				<td>아이디:</td>
				<td><input type="text" name="mid" required="required"></td>
			</tr>
			<tr>
				<td>비밀번호:</td>
				<td><input type="password" name="mpwd" required="required"></td>
			</tr>
			<tr>
				<td>이름:</td>
				<td><input type="text" name="mname" required="required"></td>
			</tr>
			<tr>
				<td>이메일:</td>
				<td><input type="text" name="memail" required="required"></td>
			</tr>
		</table>
		<input type="submit" value="회원가입">
		<button type="button" id="mainBtn">뒤로가기</button>
	</form>
<script>
    $(document).ready(function() {
        $("form").submit(function(event) {
            // 이 부분에서 실제 회원가입 처리를 수행합니다.
            // 성공 시에 아래 코드를 실행합니다.
            
            // 회원가입 성공 알림창 띄우기
            alert("회원가입에 성공했습니다.");
        });
    });
    
   	$("#mainBtn").click(function() {
		window.location.href="${pageContext.request.contextPath}/";		
   	});
</script>
</body>
</html>