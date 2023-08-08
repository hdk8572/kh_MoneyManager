<%@page import="java.util.List"%>
<%@page import="gagyebu.dk.list.model.dto.gagyebuListDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>가계부 등록 결과</title>
<style>


</style>
</head>
<body>
	<%
	List<gagyebuListDto> volist = (List<gagyebuListDto>)request.getAttribute("gagyebuList");
	%>
	<h1>지출 내역</h1>

		<div class="wrap-table">
			<div class="sector1">	
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
							gagyebuListDto gList = volist.get(i);
						%>
						<tr>
							<%-- <td><a href="${pageContext.request.contextPath}/user/get"><%=gList.getInsertDate() %><a></td> --%>
							<td><%=gList.getInsertDate() %></td>
							<td><%=gList.getMno() %></td>
							<td><%=gList.getMid() %></td>
							<td><%=gList.getMprice() %></td>
							<td><%=gList.getCategory() %></td>
							<td><%=gList.getCashCard() %></td>
							<td><%=gList.getMname() %></td>
							<td><%=gList.getDescripion() %></td>
						</tr>
						<%
						}
						%>
					</table>
					<a href="${pageContext.request.contextPath}/">되돌아가기</a>
				</form>
			</div>
			<div class="sector2">
		 		<form action="<%=request.getContextPath() %>/user/list" method="post">
			 		<table border="1">
				 		<tr>
				 			<td colspan="2">지출 정보 등록</td>
				 		</tr>
						<tr>
							<td>날짜</td>
							<td><input type="date" name="insertDate" id="currentDate"></td>
						</tr>
			<!-- 			<tr>
							<td>등록번호</td>
							<td><input type="text" name="mno"></td>
						</tr> -->
						<tr>
							<td>아이디</td>
							<td><input type="text" name="mid" required></td>
						</tr>
						<tr>
							<td>가격</td>
							<td><input type="text" name="mprice" required></td>
						</tr>
						<tr>
							<td>분류</td>
							<td><input type="text" name="category" required></td>
						</tr>
						<tr>
							<td>자산</td>
							<td><input type="text" name="cashCard" required></td>
						</tr>
						<tr>
							<td>이름</td>
							<td><input type="text" name="mname" required></td>
						</tr>
						<tr>
							<td>설명</td>
							<td><input type="text" name="descripion"></td>
						</tr>
					</table>
					<button type="submit">등록</button>
				</form>
			</div>
		</div>
	<form action="${pageContext.request.contextPath}/selectDate" method="get"> <!-- 달력 % 버튼 -->
      <p><input type="date" name="searchInsertDate" id='currentDate1'> <input type="submit" value="조회"></p>

   	</form>
</body>
<script>
	document.getElementById('currentDate').value = new Date().toISOString().substring(0, 10);

	document.getElementById('currentDate1').value = new Date().toISOString().substring(0, 10);

</script>
</html>