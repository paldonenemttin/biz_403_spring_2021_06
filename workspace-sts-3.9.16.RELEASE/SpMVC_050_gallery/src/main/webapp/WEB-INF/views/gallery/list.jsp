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
<%@ include file="/WEB-INF/views/include/include_gallery_search.jsp"%>
<section id="image">
	<c:forEach
		items="${GALLERYS}"
		var="gallery">
		<div class="ga_box">
			<div id="tit_img">
				<c:if test="${empty gallery.g_image}">
					<img
						src="${rootPath}/files/noImage.jpg"
						width="200px"
						height="120px">
				</c:if>
				<c:if test="${not empty gallery.g_image}">
					<img
						src="${rootPath}/files/${gallery.g_image}"
						width="100px">
				</c:if>
			</div>
			<div id="sub_con">
				<h3>
					<a href="${rootPath}/gallery/detail2/${gallery.g_seq}">${gallery.g_subject}</a>
				</h3>
				<p>${gallery.g_content}</p>
			</div>
		</div>

	</c:forEach>
</section>
<%@ include file="/WEB-INF/views/include/include_page.jsp"%>
