<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
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
<link href="${rootPath}/static/css/freeboard.css?ver=2021-06-14-005"
	rel="stylesheet" />
<script src="https://kit.fontawesome.com/7f8ef4d19e.js"
	crossorigin="anonymous"></script>

<body>

	<h2>자유게시판</h2>
	<hr></hr>
	<div class="main">
		<div class="btn_writ">
			<button id="write" onclick="location.href='freeboard/input'"
				value="글쓰기">글쓰기</button>
		</div>
		<div>
			<table>
			<c:choose>
				<tr class="table">
					<th id="th_no">번호</th>
					<th id="th_title">제목</th>
					<th id="th_au">작성자</th>
					<th id="th_time">작성시간</th>
				</tr>
				<tr class="value">
					<td id="td_no">${nt_seq}</td>
					<td id="td_title"><a href="freeboard/view" ></a>${nt_title}</td>
					<td id="td_writer">${nt_user}</td>
					<td id="td_time">${nt_user}</td>
				</tr>
				</c:choose>
			</table>
		</div>
		<div class="ser_title">
			<i class="fas fa-search"></i> <input id="search" type="text"
				placeholder="키워드를 입력하세요" />
			<button id="sear_click">검색</button>
		</div>
	</div>

</body>
<script type="text/javascript">
document.querySelector("#write").addEventListener("click",(e)=>{
    alert("작성 페이지로 이동합니다.");
});
</script>
</html>