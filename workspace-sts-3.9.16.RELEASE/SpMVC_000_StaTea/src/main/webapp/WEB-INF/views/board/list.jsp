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
	width: 100%;
}
h2 {
	margin-top: 5px;
	text-align: center;
	color:rgb(3, 102, 53);
}
/* 검색창 */
div.ser_title {
	display: flex;
	align-items: center;
	justify-content:center;
}

input#search {
	font-size:15px;
	height: 25px;
	width: 400px;
}

i {
	margin-right: 2px;
	font-size: 25px;
}
/* 게시물 표 */
table {
	margin:auto;
	width:100%;
	border-collapse: collapse;
	border-spacing: 0;
}
div.all_table{
	
}
table th, td {
	border: 1px solid #aaa;
	padding: 3px 5px;
	height: 10px;
	font-size: 15px;
	border-left: none;
	border-right: none;
}

tr.value:hover {
	cursor: pointer;
	background-color: #F2F5F4;
	transition: background-color 0.2s;
}

th, td {
	text-align: center;
}

th#th_au, td#td_au {
	width: 10px;
}

th#th_date, td#td_date {
	width: 10px;
}

th#th_time, td#td_time {
	width: 10px;
}

th#th_title, th#td_title {
	width: 100px;
}

th#th_no, td#td_no {
	width: 10px;
}

th#th_avo, td#td_avo {
	width: 10px;
}
a{
	text-decoration: none;
	
}
a:hover{
	cursor: pointer;
}
/* 버튼 */
button {
	padding: 7px 12px;
	background-color: rgb(3, 102, 53);
	color: white;
	border: none;
	border-radius: 5px;
	font-size: 15px;
	transition: background-color 0.3s;
	margin-bottom: 5px
}

button:hover {
	padding: 7px 12px;
	background-color: rgb(68, 32, 32);
	color: white;
	border: none;
	border-radius: 5px;
	font-size: 15px;
	transition: background-color 0.3s;
	box-shadow: 1px 1px 1px gray;
	margin-bottom: 5px;
	
}

button#write {
	margin-left: 80%;
	margin-top: 5px;
	font-size: 12px;
}

button#sear_click {
	font-size: 12px;
	margin-left: 8px;
	margin-top: 5px; 
}
div.main{
	height:79%; 
	position: relative;
	padding-bottom: 20px;
}
div.cate_body{
	text-align: center;
}

</style>
<script src="https://kit.fontawesome.com/7f8ef4d19e.js"
	crossorigin="anonymous"></script>

<body>

	<h2>자유게시판</h2>
	<hr></hr>
	<div class="main">
		<div class="btn_writ">
			<button id="write" onclick="location.href='${rootPath}/board/input'"
				value="글쓰기">글쓰기</button>
		</div>
		<div>
			<table>
			<tr class="table">
					<th id="th_no">번호</th>
					<th id="th_title">제목</th>
					<th id="th_au">작성자</th>
					<th id="th_avo">추천수</th>
					<th id="th_vcount"></th>
					<th id="th_date">작성일</th>
					<th id="th_time">작성시간</th>
				</tr>
			
				<tr class="value">
					<td id="td_no">1</td>
					<td id="td_title"><a href="board/view"></a></td>
					<td id="td_writer"></td>
					<td id="td_avo">111</td>
					<th id="th_vcount"></th>
					<td id="td_date">yyyy-mm-dd</td>
					<td id="td_time">hh:mm:ss</td>
				</tr>
			
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