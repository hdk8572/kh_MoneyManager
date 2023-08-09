<%@page import="semi.dk.user.model.dto.UserDto"%><%@page import="java.util.List"%><%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<style>
.grid-wrap{
	display:grid;
	grid-template-columns:  auto auto;
}
</style>
</head>
<body>
	<h2>ajax test</h2>
	<% List<UserDto> volist = (List<UserDto>)request.getAttribute("ulist"); %>
	
	
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
<%--  			<%
			for(int i=0;i<volist.size(); i++) {
				UserDto ul = volist.get(i);
			%> --%>
			<tr>
				<td>${ulist.insertDate}</td>
				<td>${ulist.Mno}</td>
				<td>${ulist.Mid}</td>
				<td>${ulist.Mprice}</td>
				<td>${ulist.Category}</td>
				<td>${ulist.CashCard}</td>
				<td>${ulist.Mname}</td>
				<td>${ulist.Descripion}</td>
			</tr>

		</table>
		<a href="${pageContext.request.contextPath}/">되돌아가기</a>
	</form>
	<form action="<%=request.getContextPath() %>/user/main.main" method="post">	
 		<table border="1">
	 		<tr>
	 			<td colspan="2">지출 정보 등록</td>
	 		</tr>
			<tr>
				<td>날짜</td>
				<td><input type="date" name="insertDate" id="currentDate"></td>
			</tr>
<!-- 		<tr>
				<td>등록번호</td>
				<td><input type="text" name="mno"></td>
			</tr> -->
			<tr>
				<td>아이디</td>
				<td><input type="text" name="mid" ></td>
			</tr>
			<tr>
				<td>가격</td>
				<td><input type="text" name="mprice" ></td>
			</tr>
			<tr>
				<td>분류</td>
				<td><input type="text" name="category" ></td>
			</tr>
			<tr>
				<td>자산</td>
				<td><input type="text" name="cashCard" ></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="mname" ></td>
			</tr>
			<tr>
				<td>설명</td>
				<td><input type="text" name="descripion"></td>
			</tr>
		</table>
		<button type="submit" id="ajaxlist">등록</button>
	</form>
</body>
<script>
	/* document.getElementById('currentDate').value = new Date().toISOString().substring(0, 10); */
	/* document.getElementById('currentDate1').value = new Date().toISOString().substring(0, 10); */
	
	${"#ajaxlist"}.click(ajaxListClickHandler);
	
	function ajaxListClickHandler() {
		console.log("ajaxlist click");
		$.ajax ({
			url: "${pageContext.request.contextPath}/ajax"
			, type: "post"
			, success: ajaxListSuccess
			, dataType: "json"
		});
	}
	
	function ajaxListSuccess(result){
		if(result) {
			for(var i=0; i<result.ulist.length; i++){
				var dvo = result.ulist[i]; 
				console.log(dvo.insertDate);
			}
		}
		
		displayDepartment(result.ulist);
	}
	
	function displayDepartment(ulist){
		htmlVal = "<td>날짜</td><td>번호</td><td>등록아이디</td><td>가격</td><td>품목분류</td><td>자산</td>	<td>이름</td><td>설명</td>";
		for(var i=0; i<ulit.length;i++){
			var dvo = ulist[i];
			htmlVal+= `
				<td>\${dvo.insertDate}</td>
				<td>${dvo.Mno}</td>
				<td>${dvo.Mid}</td>
				<td>${dvo.Mprice}</td>
				<td>${dvo.Category}</td>
				<td>${dvo.CashCard}</td>
				<td>${dvo.Mname}</td>
				<td>${dvo.Descripion}</td>
			`;
/* 			htmlVal +="<div>"+dvo.insertDate+"</div>";
			htmlVal += "<div>"+dvo.Mno+"</div>";
			htmlVal += "<div>"+dvo.Mid+"</div>";
			htmlVal += "<div>"+dvo.Mprice+"</div>";
			htmlVal += "<div>"+dvo.Category+"</div>";
			htmlVal += "<div>"+dvo.CashCard+"</div>";
			htmlVal += "<div>"+dvo.Mname+"</div>";
			htmlVal += "<div>"+dvo.Descripion+"</div>"; */
		}
		$('.grid-wrap').html(htmlVal);	
	}
</script>
</html>