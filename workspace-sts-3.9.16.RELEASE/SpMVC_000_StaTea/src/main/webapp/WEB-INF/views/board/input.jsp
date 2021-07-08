<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<link href="${rootPath}/static/css/input.css?ver=2021-06-14-008"
	rel="stylesheet" />

<meta charset="UTF-8">
<title>글 작성 페이지</title>
</head>
<body>

	<h3>자유게시판 글 작성</h3>
<form method="POST">
	<div class="input">
		<div class="tit_con">
			<input id="title" type="text" name="bd_title" placeholder="제목을 입력하세요" />
			<input id="id" type="hidden" name="bd_user" value="${USER.user_id}">
			<textarea id="box" name="content" placeholder="내용을 입력하세요"></textarea>
		</div>
		<div class="under">
			<input id="date" name="bd_date" value="${FREE.bd_time}"/>
			<button id="save" onclick="location.href='/statea/board'">저장</button>
		</div>
		<!--파일 업로드-->
		<div class="file">
			<input id="image" multiple="multiple" type="file" name="m_file" />
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