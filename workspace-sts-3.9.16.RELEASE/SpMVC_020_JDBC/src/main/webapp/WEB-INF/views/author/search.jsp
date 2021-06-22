<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />    
<%@ include file="/WEB-INF/views/include/head.jspf"%>
<!DOCTYPE html>
<html>
<body>
	<h1 class="page_title">저자정보</h1>
	<section class="search_sec">
	<table>
		<tr data-acode="${AUTH.au_code}" class="search_author">
			<th>CODE</th>
			<th>저자명</th>
			<th>전화번호</th>
			<th>주소</th>
			<th>주요장르</th>
		</tr>
		<tr>
			<td>CODE</td>
			<td>저자명</td>
			<td>전화번호</td>
			<td>주소</td>
			<td>주요장르</td>
		</tr>
	</table>
	</section>
	<div class="btn_box">
		<button class="btn_insert author">저자등록</button>
	</div>

</body>
<script>
document.querySelector("button.btn_insert")// 동시 적용
	.addEventListener("click",()=>{
		location.href = "${rootPath}/author/insert";
});
</script>

</html>