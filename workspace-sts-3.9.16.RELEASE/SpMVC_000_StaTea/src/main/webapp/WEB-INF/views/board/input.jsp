<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 작성 페이지</title>
<style>
@charset "UTF-8";
body{
	height: 100%;
}

p#nit {
	font-size: 5px;
}

h3 {
	margin-bottom: 5px;
	margin-left: 20%;
}

div.input {
	margin-left: 20%;
	margin-bottom: 202px;
}

div.tit_con {
	display: flex;
	flex-wrap: wrap;
	margin-top: 10px;
}

input#title {
	width: auto;
	width: 50%;
	height: 22px;
	font-size: 12px;
	margin-bottom: 10px;
}

input#user {
	width: 18%;
	height: 22px;
	font-size: 12px;
	margin-bottom: 10px;
	margin-left: 24px;
}

input#date {
	width: 130px;
}

input#time {
	width: 130px;
}

textarea#box {
	padding:2px 2px;
	width: 70%;
	height: 200px;
	font-size: 12px;
	resize: none;
	/*자동 스크롤*/
	overflow: auto;
}

button#save {
	margin-left: 40%;
	padding: 5px 19px;
	background-color: rgb(3, 102, 53);
	color: white;
	border: none;
	border-radius: 5px;
	font-size: 10px;
	height: 27px;
	margin-top: 5px;
}

button#save:hover {
	cursor: pointer;
	padding: 5px 19px;
	background-color: rgb(68, 32, 32);
	color: white;
	border: none;
	border-radius: 5px;
	font-size: 10px;
	transition: background-color 0.3s;
	box-shadow: 1px 1px 1px gray;
}

input#image {
	font-size: 5px;
}
</style>
</head>
<body>
	<h3>글 작성</h3>
	<hr></hr>
	<form method="POST">
	<div class="input">
		<div class="tit_con">
			<input id="title" type="text" name="bd_title" placeholder="제목을 입력하세요" />
			<textarea id="box" name="bd_content" placeholder="내용을 입력하세요"></textarea>
		</div>
		<div class="under">
			<input>
			<button id="save" onclick="location.href='/statea/board/list'">저장</button>
		</div>
		<!--파일 업로드-->
		<div class="file">
			<input id="file" multiple="multiple" type="file" />
		</div>
	</div>
	</form>
	
</body>
<script type="text/javascript">
document.querySelector("#save").addEventListener("click",(e)=>{
    alert("데이터를 저장합니다.");
});
</script>
</html>