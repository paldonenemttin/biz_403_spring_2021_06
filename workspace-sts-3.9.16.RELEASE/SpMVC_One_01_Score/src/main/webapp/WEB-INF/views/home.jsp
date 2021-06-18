<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>대한고교 성적처리</title>
</head>
<body>
	<header>
		<h1>대한고교 성적처리 2021 V1</h1>
	</header>
	<nav>
		<ul>
			<li>HOME</li>
			<li>학생정보</li>
			<li>성적일람표</li>
			<li>성적등록</li>
			<li>로그인</li>
		</ul>
	</nav>
	<div>
		<table>
			<tr>
				<th>학번</th>
				<th>이름</th>
				<th>전공</th>
				<th>학년</th>
				<th>응시과목</th>
				<th>총점</th>
				<th>평균</th>
			</tr>
			<tr>
				<td>${S.st_code}</td>
				<td>${S.st_name}</td>
				<td>${S.st_spec}</td>
				<td>${S.st_grade}</td>
				<td>${A.as_count}</td>
				<td>${A.as_all}</td>
				<td>${A.as_float}</td>
			</tr>
		</table>
	</div>
</body>
</html>