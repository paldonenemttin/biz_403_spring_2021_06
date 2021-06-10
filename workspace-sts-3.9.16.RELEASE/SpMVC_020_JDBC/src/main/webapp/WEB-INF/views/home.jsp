<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나의 홈페이지</title>
<%@ include file="/WEB-INF/views/include/head.jspf" %>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/include_header.jspf"%>
	<section id="main_sec">
		<article>
			<h3>출판사</h3>
			<ol>
				<li>출판사 정보</li>
				<li>출판사 정보</li>
				<li>출판사 정보</li>
				<li>출판사 정보</li>
				<li>출판사 정보</li>
			</ol>
		</article>
		<article>
			<h3>도서</h3>
			<ul>
				<li>도서정보</li>
				<li>도서정보</li>
				<li>도서정보</li>
				<li>도서정보</li>
				<li>도서정보</li>
			</ul>
		</article>
		<article>
			<h3>저자</h3>
			<ul>
				<li>저자정보</li>
				<li>저자정보</li>
				<li>저자정보</li>
				<li>저자정보</li>
				<li>저자정보</li>
			</ul>
		</article>
	</section>
	<section id="ad_sec">
		<article></article>
		<article></article>
		<article></article>
		<article></article>
		<article></article>
	</section>
	<%@ include file="/WEB-INF/views/include/include_footer.jspf"%>

</body>
</html>