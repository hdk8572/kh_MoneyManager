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

	
	
	<% List<gagyebuUserDto> volist = new List<gagyebuUserDto>();%>
	
	${gagyebuList}
	
	
	<form>
		<table border="1">
			<tr>
				<td>${gagyebuList.insertDate}</td>
				<td>${gagyebuList.mno}</td>
				<td>${gagyebuList.mid}</td>
				<td>${gagyebuList.mprice}</td>
				<td>${gagyebuList.category}</td>
				<td>${gagyebuList.cashCard}</td>
				<td>${gagyebuList.mname}</td>
				<td>${gagyebuList.descripion}</td>
			</tr>
			
			<%= for(i=0;i<volist.size(); i++) {
					gagyebuUserDto udto = get(i)
			<tr>
				<td>${gagyebuList.insertDate}</td>
				<td>${gagyebuList.mno}</td>
				<td>${gagyebuList.mid}</td>
				<td>${gagyebuList.mprice}</td>
				<td>${gagyebuList.category}</td>
				<td>${gagyebuList.cashCard}</td>
				<td>${gagyebuList.mname}</td>
				<td>${gagyebuList.descripion}</td>
			</tr>
			} %>
			
			<tr>

			</tr>
		</table>
	</form>
	
	
	
</body>
</html>