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
<form method="POST" enctype="multipart/form-data">
	<div class="input">
		<div class="tit_con">
		<input id="code" type="text" name="bd_code" value="${FREE.bd_code}">
			<input id="title" type="text" name="bd_title" placeholder="제목을 입력하세요" />
			<input id="id" type="hidden" name="bd_user" value="${USER.user_id}">
			<input id="date" type="hidden" name="bd_time" value="${FREE.bd_time}"/><p>${FREE.bd_time}</p>
			<textarea id="box" name="bd_content" placeholder="내용을 입력하세요"></textarea>
		</div>
		<div class="under">
			<button id="save">저장</button>
		<!--파일 업로드-->
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