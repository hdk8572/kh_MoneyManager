<%@page import="java.util.List"%>
<%@page import="gagyebu.dk.user.model.Dto.gagyebuUserDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>가계부 등록 결과</title>
</head>
<body>
	<% List<gagyebuUserDto> volist = (List<gagyebuUserDto>)request.getAttribute("gagyebuList");%>
	<form>
		<table border="1">
			<tr>
				<td>날짜</td>
				<td>번호</td>
				<td>등록아이디</td>
				<td>가격</td>
				<td>품목분류</td>
				<td>자산</td>
				<td>이름</td>
				<td>설명</td>
			</tr>
			
			<%
			for(int i=0;i<volist.size(); i++) {
				gagyebuUserDto gList = volist.get(i);
			%>
			
			<td><a href="${pageContext.request.contextPath}/user/get"><%=gList.getInsertDate() %><a></td>
			
			<td><%=gList.getMno() %></td>
			<td><%=gList.getMid() %></td>
			<td><%=gList.getMprice() %></td>
			<td><%=gList.getCategory() %></td>
			<td><%=gList.getCashCard() %></td>
			<td><%=gList.getMname() %></td>
			<td><%=gList.getDescripion() %></td>
			
			<%
			}
			%>
			
			<a href="${pageContext.request.contextPath}/">되돌아가기</a>
			
		</table>
	</form>
</body>
</html>