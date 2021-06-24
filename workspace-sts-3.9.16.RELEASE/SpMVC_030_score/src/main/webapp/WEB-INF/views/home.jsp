<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewprot" content="width=divice=width, initial-scale:1">
<title>나의 홈페이지</title>
<style>
* {
	box-sizing: border-box;
	margin: 0;
	padding: 0;
}

body {
	width: 100%;
	height:100%;
	display: flex;
	flex-direction: column;
	overflow: auto;
}

header {
	background: url("${rootPath}/static/images/header_background.png");
	background-size: 100% 100%;
	background-position: top;
	background-attachment: fixed;
	text-align: center;
	color: white;
	text-shadow: 1px 1px 1px #aaa;
	padding: 2rem;
}

section#main_sec {
	width: 100wv;
	display: flex;
	flex-direction: column;
	background: linear-gradient(to bottom, blue, green);
	background-size: 100% 100%;
	background-attachment: fixed;
	
}

table {
	border: 0;
	width: 90%;
	border-collapse: collapse;
	border-spacing: 0;
	margin: 10px auto;
}

tr {
	border-top: 1px solid green;
}

tr:last-child {
	border-bottom: 1px solid green;
}

tr:nth-of-type(odd){
	background-color: #aaa;
}

tr:nth-of-type(even){
	background-color: #ccc;
}

tr:hover td{
	background-color: #aaa;
	cursor: pointer;
}
td, th {
	border-right: 1px solid green;
	padding: 8px 10px;
	text-align: center;
}
td.number{
	text-align: right;
}
td:last-child, th:last-child {
	border: none;
}
div.btn_box{
	width:90%;
	/*
		table의 margin:10px auto로 설정되어 있기 때문에
		top margin은 0으로 bottom margin은 10px 좌우는 auto
	*/
	margin: 8px auto 10px auto; 
	padding: 5px;
	text-align: right;
}
div.btn_box button{
	border:0;
	outline:0;
	padding:12px 16px;
	margin-left: 10px;
	border-radius: 5px;
}
button:hover{
	box-shadow: 2px 2px 2px 2px black;
	cursor: pointer;
}
button.score.insert{
	background-color: rgba(0,0,200,1);
	color: white;
}
button.score.student{
	background-color: orange;
	color: white;
}
h2{
	width:90%;
}

form{
	width:90%;
	margin: 0 auto 10px auto;
}
fieldset{
	background-color: #eee;
	border: 1px solid green;
	border-radius: 5px;
	padding: 0.7rem;
}
form label, form input{
	display: inline-block;
	margin: 5px;
	padding: 8px 16px;
}
from label{
	width: 30%;
	text-align: right;
	color:blue;
	font-weight: bold;
}
form input{
	width:60%;
	outline: 0;
	border:#aaa;
	border-radius: 50px;
}
form input:hover {
	background-color: #ccc;
}
form button.save{
	background-color: blue;
	color:white;
}
form button.reset{
	background-color: olive;
	color:white;
}
form button.list{
	background-color: green;
	color:white;
}
</style>
</head>
<body>
	<header>
		<h1>대한고교 성적처리</h1>
		<p>대한고교 성적처리 시스템 2021</p>
	</header>
	<section id="main_sec">
		<c:choose>
			<c:when test="${BODY eq 'SCORE_VIEW'}">
				<%@ include file="/WEB-INF/views/score/list.jsp"%>
			</c:when>
			<c:when test="${BODY eq 'STUDENT_VIEW'}">
				<%@ include file="/WEB-INF/views/student/list.jsp" %>
			</c:when>
			<c:when test="${BODY eq 'STUDENT_INPUT'}">
				<%@ include file="/WEB-INF/views/student/input.jsp" %>
			</c:when>
			<c:otherwise>
				<%@ include file="/WEB-INF/views/main.jsp"%>
			</c:otherwise>
		</c:choose>
	</section>
</body>
<script>
/*
 js코드에서 event를 등록할때 현재 화면에 없는 DOM요소에 addEvent를 설정하면
 없는 함수라는 오류가 발생한다 그 이유는 현재 화면에 없는 DOM요소를
 querySelector하면 그 결과값이 null이기 때문에 발생하는 문제
 
 js코드를 통합하여 모음으로 관리할땐 addEvent 하려고 하는요소가 있는지를 먼저
 검사한후 addEvent를 수행해 주어야 한다
 */
let st_list = document.querySelector("button.score.student.list");
let home = document.querySelector("button.student.home")
let st_insert = document.querySelector("button.student.insert")
// st_list가 있으면
if(st_list){
	st_list.addEventListener("click", (e)=>{
		location.href = "${rootPath}/student/list"
	})
}

if(home){
	home.addEventListener("click", (e)=>{
		location.href = "${rootPath}/"
	})
}

if(st_insert){
	home.addEventListener("click", (e)=>{
		location.href = "${rootPath}/student/input"
	})
}
</script>
</html>