<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<style>
form {
	width: 80%;
	margin: a auto;
}

label, input {
	padding: 8px;
	margin: 3px;
}

label {
	display: inline-block;
	width: 20%;
	text-align: right;
}

input {
	display: inline-block;
	width: 70%;
}
</style>
<link href="${rootPath}/static/css/main.css" ref="stylesheet"/>
<html>
<head>
<meta charset="UTF-8">
<title>나의 홈페이지</title>
</head>
<body>
	<h1>이곳은 나의 홈페이지 환영 못해</h1>
	<!-- 
	form에 네이버, 다음 구글 검색 URL을 aCTIOn으로 지정하고
	INPUT의 NAME속성에 각 검색용 QUERy 변수명을 사용하면
	input에 검색어를 입력한 후 Enter를 누르면
	각 검색 사이트에 데이터를 전송하고 결과를 화면에 보여준다
	
	action 값이 http:// 도는 https://로 시작되는 경우는
	현재의 localhost에 요청을 보내는 것이 나니고
	외부에 URI(URL)로 전동을 하게 된다
	 -->
	<form action="https://search.naver.com/search.naver?query=대한민국">
		<label>네이버검색</label> <input name="query">
	</form>
	<form action="https://search.daum.net/search?q=니똥꼬칼라파워">
		<label>다음검색</label> <input name="q">
	</form>
	<form action="https://www.google.com/search?q=바보">
		<label>구글검색</label> <input name="q">
	</form>
</body>
</html>