<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
<
style>p#nit {
	font-size: 5px;
}

h3 {
	padding-left: 10%;
}

div#input {
	padding-left: 30%;
}

form#image {
	font-size: 10px;
}

div.input {
	margin-left: 20%;
}

div.tit_con {
	display: flex;
	flex-wrap: wrap;
	margin-top: 30px;
}

input#title {
	width: auto;
	width: 50%;
	height: 20px;
	font-size: 12px;
	margin-bottom: 10px;
}

input#user {
	width: 18%;
	height: 20px;
	font-size: 12px;
	margin-bottom: 10px;
	margin-left: 5px;
}

textarea#box {
	width: 70%;
	height: 200px;
	font-size: 12px;
	resize: none;
	/*자동 스크롤*/
	overflow: auto;
}

button#save {
	margin-left: 26%;
	padding: 7px 20px;
	background-color: green;
	color: white;
	border: none;
	border-radius: 3px;
	font-size: 10px;
	transition: background-color 0.3s;
	height: 27px;
	margin-top: 5px;
}

button#save:hover {
	cursor: pointer;
	padding: 7px 20px;
	background-color: rgb(68, 32, 32);
	color: white;
	border: none;
	border-radius: 3px;
	font-size: 10px;
	transition: background-color 0.3s;
}

div.file {
	margin-left: 20%;
}

div#preview {
	display: flex;
	flex-wrap: wrap;
	background-color: #F2F5F4;
}
</style>

</head>
<body>
 <h3>글 작성</h3>
    <hr></hr>
    <div class="input">
      <div class="tit_con">
      <input id="title" type="text" name="st_title" placeholder="제목을 입력하세요"/>
      <input id="user" type="text" name="st_name" placeholder="닉네임입력"/>
        <textarea id="box" name="content" placeholder="내용을 입력하세요"></textarea>
      </div class="under">
      <input name="st_date" type="date">
      <input name="st_time" type="time">
      <button id="save" type="button" class="save_btn">저장</button>
    </div>
    <!--파일 업로드-->
    <div class="file">
      <input multiple="multiple" type="file" name="filename" />
      <div id="preview"></div>
    </div>
</body>
</html>