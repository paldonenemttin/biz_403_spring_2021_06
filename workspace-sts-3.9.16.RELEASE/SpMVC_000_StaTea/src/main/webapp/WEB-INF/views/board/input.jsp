<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>


<meta charset="UTF-8">
<title>글 작성 페이지</title>
</head>
<body>
	<h3>글 작성</h3>
	<hr></hr>
	<c:forEach items="${INPUT}" var="in">
	<div class="input">
		<div class="tit_con">
			<input id="title" type="text" name="board_title" placeholder="제목을 입력하세요" />
			<textarea id="box" name="board_content" placeholder="내용을 입력하세요"></textarea>
		</div>
		<div class="under">
			<input id="date" name="st_date" type="date" /> <input id="time"
				name="board_time" type="time" />
			<button id="save" onclick="location.href='/statea/board/list'">저장</button>
		</div>
		<!--파일 업로드-->
		<div class="file">
			<input id="file" multiple="multiple" type="file" name="img_src" />
		</div>
	</div>
	</c:forEach>
	
</body>
<script type="text/javascript">
document.querySelector("#save").addEventListener("click",(e)=>{
    alert("데이터를 저장합니다.");
});
</script>
</html>