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

html, body {
	width: 345px;
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
	margin-left: 25%;
	border-collapse: collapse;
	border-spacing: 0;
	height: 10px;
	width: 50%;
}

td, th {
	text-align: center;
	padding: 1px 2px;
	height: 10px;
	font-size: 5px;
	width: 12.5%;
}

th#th_date, td#td_date {
	width: 12.5%;
}

th:first-child, th:last-child, td:first-child, td:last-child {
	border-left: none;
	border-right: none;
}

div.main_cont {
	margin-left: 5%;
	border: 1px solid #aaa;
	width: 100%;
	height: 60%;
}

p#content {
	margin: 2px 2px 2px 2px;
	font-size: 10px;
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

button#list {
	font-size: 12px;
	margin-left: 5px
}

div.view_cont {
	position: relative;
}

div.btn_avo_list {
	padding-bottom: 52px;
}
img{
max-width:150px;
max-height: 150px;
}
</style>
</head>
<body>
	<div class="state">
		<table>
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

	<div class="btn_avo_list">
		<button id="list" onclick="location.href='/statea/board/list'">목록으로</button>
		<button id="update">수정</button>
		<button id="delete">삭제</button>
		<!--
		회원 기능 생길시 사용할 코드 
		<c:if test="${USER.user_id == USER.user_id}">
			<button id="update">수정</button>
			<button id="delete">삭제</button>
		</c:if>
		 -->
	</div>

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