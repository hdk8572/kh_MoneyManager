<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>안녕</h1>
	<br>
	<table border="1">
		<tr>
			<td>날짜</td>
			<td>등록번호</td>
			<td>아이디</td>
			<td>가격</td>
			<td>분류</td>
			<td>자산</td>
			<td>이름</td>
			<td>설명</td>
		</tr>
		<tr>
			<td>${sdate.insertDate}</td>
			<td>${sdate.mno}</td>
			<td>${sdate.mid}</td>
			<td>${sdate.mprice}</td>
			<td>${sdate.category}</td>
			<td>${sdate.cashCard}</td>
			<td>${sdate.mname}</td>
			<td>${sdate.descripion}</td>
		</tr>
	</table>
</body>
</html>