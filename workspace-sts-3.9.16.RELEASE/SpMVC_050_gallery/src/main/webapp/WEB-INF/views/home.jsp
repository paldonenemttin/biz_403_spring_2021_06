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
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나의 홈페이지</title>
<style>
* {
	margin: 0;
}
/*list css*/ 

h1 {
	text-align: center;
}

div.ga_box {
	border: 1px solid black;
	border-radius: 5px;
	width: 100vh;
	height: 20vh;
	margin: 10px 25%;
	display: flex;
	justify-content: center;
}

div.header {
	background-color: gray;
	padding: 20px;
}
/*list end*/

/*detail*/
div#gallery_info {
	margin: 10px 25%;
	border: 1px solid black;
	width: 100vh;
	height: 30px;
	display: flex;
	justify-content: space-around;
}

h3 {
	text-align: center;
}

div.au_date {
	display: flex;
	margin: 0;
}

div#gallery_files {
	display: flex;
	justify-content: space-around;
}

div#link {
	margin-top:20px;
	text-align: center;
	font-size: 20px;
}
/* detail end */

/* input */
div.title {
	width: 50%;
	height: 20px;
	font-size: 20px;
	padding: 3px;
	margin: auto;
}

div.content{
	text-align: center;
}
div.image{
	text-align: center;
}
</style>
</head>
<body>
	<div class="header">
		<h1>갤러리</h1>
	</div>
	<div class="content">
		<c:choose>
			<c:when test="${BODY eq 'GA-INPUT'}">
				<%@ include file="/WEB-INF/views/gallery/input.jsp"%>
			</c:when>

			<c:when test="${BODY eq 'GA-LIST'}">
				<%@ include file="/WEB-INF/views/gallery/list.jsp"%>
				<a href="${rootPath}/gallery/input">이미지등록</a>
			</c:when>
			<c:when test="${BODY eq 'GA-DETAIL'}">
				<%@ include file="/WEB-INF/views/gallery/detail.jsp"%>
			</c:when>
				<c:otherwise>
					<a href="${rootPath}/gallery/input">이미지등록</a>
				</c:otherwise>
		</c:choose>
	</div>
	<div class="image">
		<c:forEach
			items="${FILES}"
			var="file">
			<a
				href="${rootPath}/files/${file}"
				target="_NEW"> <img
				src="${rootPath}/files/${file}"
				width="100px">
			</a>
		</c:forEach>
		<img
			src="${rootPath}/files/${file}"
			width="100px" />
	</div>
</body>
</html>