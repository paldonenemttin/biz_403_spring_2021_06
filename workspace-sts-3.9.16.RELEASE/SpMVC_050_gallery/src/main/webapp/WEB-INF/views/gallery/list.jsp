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
<style>
div.ga_box {
	display: flex;
}

div.ga_box:first-of-type {
	flex: 1;
}

div.ga_box:last-of-type {
	flex: 3;
}
</style>
<c:forEach
	items="${GALLERYS}"
	var="gallery">
	<div class="ga_box">
		<div>
			<img src="${rooPath}/files/${gallery.g_image}">
			<div>
				<h3><a href="${rootPath}/gallery/detail/${GALLERY.g_seq}">${gallery.g_subject}</a></h3>
				<p>${gallery.g_content}</p>
			</div>
		</div>
	</div>
</c:forEach>
