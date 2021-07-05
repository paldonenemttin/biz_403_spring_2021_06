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
</head>
<body>
	<h1>갤러리</h1>
	<form
		method="POST"
		enctype="multipart/form-data">
		<div>
			<input
				type="file"
				name="one_file">
			<button>전송</button>
		</div>
		<div>
			<input
				type="file"
				name="m_file"
				multiple="multiple">
		</div>
	</form>

	<c:forEach
		items="${FILES}"
		var="file">
		<a href="${rootPath}/file/${file}"> <img
			src="${rootPath}/files/${file}"
			width="200px"> <img
			src="${rootPath}/files/title.jpg"
			width="200px">
		</a>
	</c:forEach>

</body>
</html>