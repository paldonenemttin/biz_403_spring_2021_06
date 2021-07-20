<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
* {
	box-sizing: border-box;
}

body {
	height: 100%;
}

p#title {
	font-size: 20px;
	padding-bottom: 15px;
}

div.view {
	margin: auto;
}

table {
	border: 1px solid black;
	margin-left: 5%;
	margin-bottom: 20px;
	border-collapse: collapse;
	border-spacing: 0;
	height: 90px;
	width: 90%;
	
}

td, th {
	text-align : center;
	padding: 1px 2px;
	height: 10px;
	font-size: 5px;
	width: 12.5%;
	text-align: center;
	font-size: 20px;
}

th:first-child, th:last-child, td:first-child, td:last-child {
	border-left: none;
	border-right: none;
}

div.main_cont {
	margin-left: 5%;
	border: 1px solid #aaa;
	width: 90%;
	padding: 50px 30px;
}

p#content {
	margin: 2px 2px 2px 2px;
	font-size: 20px;
}

button {
	padding: 5px 10px;
	background-color: rgb(3, 102, 53);
	color: white;
	border: none;
	border-radius: 5px;
	font-size: 15px;
	transition: background-color 0.3s;
	margin-bottom: 5px;
	margin-top: 2px;
}

button:hover {
	padding: 5px 10px;
	background-color: rgb(68, 32, 32);
	color: white;
	border: none;
	border-radius: 5px;
	font-size: 15px;
	transition: background-color 0.3s;
	cursor: pointer;
	box-shadow: 1px 1px 1px gray;
	margin-bottom: 5px
}

div.view_cont {
	position: relative;
}

img {
	max-width: 300px;
	max-height: 150px;
	display: flex;
	flex-direction: column;
	margin-bottom: 50px;
}

div.btn_list {
	display: flex;
	margin-top: 10px;
	margin-left: 5%;
	width: 90%;
	justify-content: space-between;
}
p{
	
}
</style>
</head>
<body>
	<div class="state">
		<table id="">
			<tr>
				<td colspan="5">${BVIEWS.bd_title}</td>
			</tr>
			<tr>
				<th id="th_author">작성자</th>
				<th id="th_date">조회수</th>
				<th id="th_time">작성시간</th>
			</tr>
			<tr>
				<td id="td_author">${BVIEWS.bd_user}</td>
				<td id="td_date">${BVIEWS.bd_vcount}</td>
				<td id="td_time">${BVIEWS.bd_time}</td>
			</tr>
		</table>
	</div>
	<div class="main_cont">
		<p id="content">${BVIEWS.bd_content}</p>
		<c:forEach items="${BVIEWS.imgList}" var="image">
			<c:if test="${not empty image.img_upname}">
				<img src="${rootPath}/board/view/statea/${image.img_upname}"
					height="200px">
			</c:if>
		</c:forEach>
	</div>

	<div class="btn_list">
		<div id="back">
			<button id="list" onclick="location.href='/starbucks/board'">목록으로</button>
		</div>
		<div id="up_del">
			<c:if test="${LOGIN.user_id == BVIEWS.bd_user}">
				<button id="update">수정</button>
				<button id="delete">삭제</button>
			</c:if>
		</div>
	</div>
	<!--
		회원 기능 생길시 사용할 코드 
		<button id="update">수정</button>
	<button id="delete">삭제</button>
		-->


</body>
<script>
      
    document.querySelector("#delete").addEventListener("click",(e)=>{
    	
    	if(confirm("해당 게시물을 삭제합니다")){
    		location.replace("${rootPath}/board/delete?bd_code=${BVIEWS.bd_code}")
    	}
    })
    
    document.querySelector("#update").addEventListener("click",(e)=>{
    	location.href= "${rootPath}/board/update/${BVIEWS.bd_code}" 
    })
    
        
  </script>
</html>