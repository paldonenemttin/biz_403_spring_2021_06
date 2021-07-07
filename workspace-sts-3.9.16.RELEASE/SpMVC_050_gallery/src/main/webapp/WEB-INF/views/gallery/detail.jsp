<%@ page
	language="java"
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib
	uri="http://java.sun.com/jsp/jstl/core"
	prefix="c"%>
<c:set
	var="rootPath"
	value="${pageContext.request.contextPath}" />
<div id="gallery_info">
	<h3>제목: ${GFLIST[0].g_subject}</h3>
	<p>작성일: ${GFLIST[0].g_date}</p>
	<p>작성시각: ${GFLIST[0].g_time}</p>
	<p>작성자: ${GFLIST[0].g_writer}</p>
	
</div>
<p>내용: ${GFLIST[0].g_content}</p>
<div id="gallery_files">
	<c:forEach
		items="${GFLIST}"
		var="file">
		<img
			src="${rootPath}/files/${file.f_upname}"
			height="200px">
	</c:forEach>
</div>
<div id="link">
<a href="${rootPath}/gallery">리스트로</a>
</div>