<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/head.jspf"%>
<meta charset="UTF-8">
<title>나의 홈페이지</title>
</head>
<%@ include file="/WEB-INF/views/include/include_header.jspf"%>
<body>
	<h1>출판사 정보 등록</h1>
	<section class="main_sec">
		<form method=POST>
			<fieldset>
				<legend>저자 정보</legend>
				<div>
					<label>출판사명</label><input name="cp_title" id="cp_title" />
				</div>
				<div>
					<label>대표자명</label><input name="cp_ceo" id="cp_ceo" />
				</div>
				<div>
					<label>전화번호</label><input name="cp_tel" id="cp_tel" />
				</div>
				<div>
					<label>주소</label><input name="cp_addr" id="cp_addr" />
				</div>
				<div>
					<label>주요장르</label><input name="cp_genre" id="cp_genre" />
				</div>
				<div class="btn_box">
					<button type="button" class="btn_save author">저장</button>
					<button type="reset" class="btn_reset author">새로작성</button>
					<button type="button" class="btn_list author">리스트로</button>
				</div>
			</fieldset>
		</form>
	</section>
	<script>
	document.querySelector("button.btn_list_author")
	.addEventListener("click",()=>{
		location.href = "${rootPath}/author";
});
			
</script>
</body>
</html>