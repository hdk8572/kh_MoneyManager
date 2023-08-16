<link href="${pageContext.request.contextPath }/resources/css/reset.css" rel="stylesheet">
<link href="${pageContext.request.contextPath }/resources/css/cssTable.css" rel="stylesheet">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>

</head>
<body>
	<div id="wrap-table">
		<div id="wrap-list"  class="tableFixHead">
			<table border="1px" id="addOne">
			 	<thead>
				<tr>
					<td class="fixedHeader">날짜</td>
					<td class="fixedHeader">번호</td>
					<td class="fixedHeader">등록아이디</td>
					<td class="fixedHeader">가격</td>
					<td class="fixedHeader">품목분류</td>
					<td class="fixedHeader">자산</td>
					<td class="fixedHeader">이름</td>
					<td class="fixedHeader">설명</td>
					<td class="fixedHeader"></td>
				</tr>
				</thead>
				<tbody>
				<c:forEach items="${ulist}" var="ul">			
				<tr>
					<td>${ul.insertDate}</td>
					<td>${ul.mno}</td>
					<td>${ul.mid}</td>
					<td>${ul.mprice}</td>
					<td>${ul.category}</td>
					<td>${ul.cashCard}</td>
					<td>${ul.mname}</td>
					<td>${ul.description}</td>
					<td>
					<button type="button" class="delete-btn" data-mno="${ul.mno}">삭제</button>
					</td>
				</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
		<div>
		<form id="frmInsert">
	 		<table>
				<tr>
					<td>날짜</td>
					<td><input type="date" name="insertDate" id="currentDate"></td>
				</tr>
				<tr>
					<td>아이디</td>
					<td><input type="text" value="${currentId}" name="mid" readonly></td>
				</tr>
				<tr>
					<td>가격</td>
					<td><input type="text" name="mprice" ></td>
				</tr>
	 			<tr>
					<td>분류</td>
					<td>
					<select name="category">
					<option>식비</option>
					<option>교통/차량</option>
					<option>주거/통신비</option>
					<option>문화생활</option>
					<option>마트/편의점</option>
					<option>패션/미용</option>
					<option>생활용품</option>
					<option>건강</option>
					<option>교육</option>
					<option>경조사/회비</option>
					</select>
					</td>
				</tr>
	 			<tr>
					<td>자산</td>
					<td>
					<select name="cashCard">
					<option>현금</option>
					<option>체크카드</option>
					<option>신용카드</option>
					</select>
					</td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="mname" required></td>
				</tr>
				<tr>
					<td>설명</td>
					<td><input type="text" name="descripion"></td>
				</tr>
				<tr></tr>
			</table>
			<br>
			<button type="button" id="btn_Insert">등록</button>
		</form>
		<a href="${pageContext.request.contextPath}/">되돌아가기</a>
		<form>
		<input type="date" name="searchDate" id="searchDate">
		<button type="button" id="searchDateBtn">검색</button>
		</form>
		</div>
	</div>
	
	
	<div class="tableFixHead">
		<table>
		<thead>
		<tr><th>a</th></tr>
		</thead>
		<tbody>
		<tr><th>a</th></tr>
		<tr><th>a</th></tr>
		<tr><th>a</th></tr>
		<tr><th>a</th></tr>
		<tr><th>a</th></tr>
		<tr><th>a</th></tr>
		<tr><th>a</th></tr>
		<tr><th>a</th></tr>
		<tr><th>a</th></tr>
		<tr><th>a</th></tr>
		<tr><th>a</th></tr>
		<tr><th>a</th></tr>
		<tr><th>a</th></tr>
		<tr><th>a</th></tr>
		<tr><th>a</th></tr>
		<tr><th>a</th></tr>
		<tr><th>a</th></tr>
		</tbody>
		</table>
	</div>
</body>
<script>
	document.getElementById('currentDate').value = new Date().toISOString().substring(0, 10);
	
  	$("#btn_Insert").click(insertListClickHandler);
  	$("#searchDateBtn").click(searchDateClickHandler);
  	$(".delete-btn").click(deleteBtnClickHandler);
	
	function insertListClickHandler() {
		var dataQuery = $("#frmInsert").serialize();
		$.ajax({
			url: "${pageContext.request.contextPath}/ajaxInsert"
			,type: "post"
			,data: $("#frmInsert").serialize()
			
			,dataType:"json"
			,success: function(result){
				console.log("success:");
				console.log(result);
				displayList(result);
				resetInputFields();
			}
			,error: function(){
				console.log("error:");
				console.log(result);
			}
		})
		
		
		
		
	}
	
	function deleteBtnClickHandler() {
		var deleteButton = $(this);
	    var mno = deleteButton.data("mno");
        console.log(mno);
        $.ajax({
            url: "${pageContext.request.contextPath}/ajaxDelete",
            type: "post",
            data: { mno: mno },
            dataType: "json",
            success: function (result) {
                console.log("Delete success:");
                console.log(result);
                deleteButton.closest("tr").remove();
                alert("삭제 성공");
            },
            error: function () {
                console.log("Delete error:");
                console.log(result);
            },
        });
    }
	
	function searchDateClickHandler() {
		console.log("날짜 검색!");
		var searchDateValue = $("#searchDate").val();
		console.log("searchDate :"+searchDateValue);
		$.ajax({
			url: "${pageContext.request.contextPath}/ajaxSearch"
			,type: "post"
			,data: {searchDate: searchDateValue}
			,dataType: "json"
			,success: function(result) {
				displaySelectOne(result);
			}
		})
	}
	
	function displayList(data) {
		var htmlVal="";
		if(data==null || data.length == 0){
			alert("등록에 실패하였습니다. 다시 입력을시도해주세요.");
		} else {
			htmlVal+=`
				<table border="1">
			<tbody>
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
				`;
				for(var i=0;i<data.length;i++){
					var ul = data[i];
				htmlVal+=`
				<tr>
					<td>\${ul.insertDate}</td>
					<td>\${ul.mno}</td>
					<td>\${ul.mid}</td>
					<td>\${ul.mprice}</td>
					<td>\${ul.category}</td>
					<td>\${ul.cashCard}</td>
					<td>\${ul.mname}</td>
					<td>\${ul.description}</td>
					<td><button type="button" class="delete-btn" data-mno="${ul.mno}">\삭제</button></td>
				</tr>
				
				`;
				}
			htmlVal+=`
			</tbody>
				</table>`;
			$("#wrap-list").html(htmlVal);
		  	$(".delete-btn").click(deleteBtnClickHandler);
			alert("등록에 성공");
			$("#frmInsert input[type='text'][name!='mid']").val('');
			$("#frmInsert select[name!='category'][name!='cashCard']").val($("#frmInsert select option:first").val());
		}
	}
</script>
</html>
