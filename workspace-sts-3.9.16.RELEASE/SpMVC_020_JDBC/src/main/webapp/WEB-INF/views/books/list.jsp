<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<%@ include file="/WEB-INF/views/include/head.jspf"%>
<style>
</style>
<body>
	<%@ include file="/WEB-INF/views/include/include_header.jspf"%>
	<h1 class="page_title">도서정보</h1>
	<table>
		<tr>
			<th>No</th>
			<th>ISBN</th>
			<th>도서명</th>
			<th>출판사</th>
			<th>저자</th>
			<th>출판연도</th>
			<th>가격</th>
			<th>페이지수</th>
		</tr>
		<c:choose>
			<c:when test="${empty BOOKS}">
				<tr>
					<td colspan="8">데이터가 없음</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${BOOKS}" var="BOOK" varStatus="ST">
					<tr>
						<td>${ST.index}</td>
						<td>${BOOK.bk_isbn}</td>
						<td><span><label class="truncate">${BOOK.bk_title}</label></span></td>
						<td><span><label class="truncate">${BOOK.bk_ccode}</label></span></td>
						<td><span><label class="truncate">${BOOK.bk_acode}</label></span></td>
						<td>${BOOK.bk_date}</td>
						<td>${BOOK.bk_price}</td>
						<td>${BOOK.bk_pages}</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>

	</table>

	<div class="btn_box">
		<button class="btn_insert book">도서등록</button>
	</div>

	<%@ include file="/WEB-INF/views/include/include_footer.jspf"%>

</body>

<script>
document.querySelector("button.btn_insert.book")
	.addEventListener("click",()=>{
		location.href = "${rootPath}/books/insert";
});
</script>

</html>