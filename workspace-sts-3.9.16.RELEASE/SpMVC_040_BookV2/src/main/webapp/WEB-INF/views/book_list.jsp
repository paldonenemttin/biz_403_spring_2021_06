<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<c:forEach items="${BOOKS}" var="BOOK">
	<div class="content">
		<img src="${BOOK.image}">
		<div>
			<p class="title">
				<a href="${BOOK.link}" target="_NEW"> ${BOOK.title} </a>
			</p>
			<p class="desc">${BOOK.description}</p>
			<p class="author">
				<strong>저자 : </strong>${BOOK.author}
			</p>
			<p class="publisher">
				<strong>출판사 : </strong>${BOOK.publisher}
			</p>
			<a href="${rootPath}/book/insert/${BOOK.isbn}" >내서재 등록</a>
			
		</div>
	</div>
</c:forEach>