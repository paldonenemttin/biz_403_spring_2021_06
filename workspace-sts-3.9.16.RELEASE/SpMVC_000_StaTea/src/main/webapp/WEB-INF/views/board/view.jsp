<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
*{
	box-sizing: border-box;
}
html,body{
	height: 100%;
}
p#title {
	font-size: 20px;
	margin-left: 25%;
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
	width:12.5%;
}

th#th_date, td#td_date{
	width:12.5%;
}

th:first-child, th:last-child, td:first-child, td:last-child {
	border-left: none;
	border-right: none;
}

div.main_cont {
	margin-left: 25%;
	border: 1px solid #aaa;
	width: 50%;
	height: 60%;
}

p#content {
	margin:2px 2px 2px 2px;
	font-size: 10px;
}
p#ex_image{
	
	margin: 2px 2px 2px 2px;
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
	margin-left: 25%;
}

button#like {
	font-size: 12px;
	margin-left: 42.3%;
}
div.view_cont{
	height:85%; 
	position: relative;
	
}
div.btn_avo_list{
	padding-bottom: 52px;
}
</style>
</head>
<body>

			<div id="view_tit">
				<hr></hr>
				<p id="title">스타벅스 커스텀</p>
			</div>
			<div class="state">
				<table>
					<tr>
						<th id="th_avo">추천수</th>
						<th id="th_author">작성자</th>
						<th id="th_date">작성일자시간</th>
					</tr>
					<tr>
						<td id="td_avo">${like_count}</td>
						<td id="td_author">${user_id}</td>
						<td id="td_date">${bd_date}</td>
					</tr>
				</table>
			</div>
			<div class="main_cont">
				<p id="content">${bd_content}</p>
				<p id="ex_image">$[img_src]</p>
			</div>
			<hr></hr>
			<div class="btn_avo_list">
				<button id="list" onclick="location.href='statea/board'">목록으로</button>
				<button id="like">추천</button>
			</div>
</body>
<script>
    document.querySelector("#like").addEventListener("click",(e)=>{
            alert("해당 게시물을 추천했습니다.");
        });
        document.querySelector("#list").addEventListener("click",(e)=>{
            alert("목록으로 돌아갑니다.");
        });
  </script>
</html>