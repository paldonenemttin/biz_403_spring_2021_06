<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나의 홈페이지</title>
</head>
<body>
<h1>냉풍기 사야겠다~</h1>
<p><a href="${rootPath}/comp/insert">출판사 추가</a></p>
<p><a href="${rootPath}/author/insert">작가 추가</a></p>
<p><a href="${rootPath}/book/insert">책 추가</a></p>
</body>
</html>