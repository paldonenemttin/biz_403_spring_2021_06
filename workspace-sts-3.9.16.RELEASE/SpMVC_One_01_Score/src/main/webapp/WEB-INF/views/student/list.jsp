<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생리스트</title>
</head>
<body>
	<div>
		<table>
			<tr>
				<th>학번</th>
				<td>학번</td>
				<th>전공</th>
				<td>전공</td>
			</tr>
			<tr>
				<th>이름</th>
				<td>이름</td>
				<th>학년</th>
				<td>학년</td>
			</tr>
		</table>
		<button>회원정보 수정</button>
	</div>
	<div>
		<table>
			<tr>
				<th>No.</th>
				<th>과목</th>
				<th>점수</th>
			</tr>
			<tr>
				<td>seq</td>
				<td>과목</td>
				<td>점수</td>
			</tr>
			<tr>
				<td>합계</td>
				<td>응시과목수</td>
				<td>총점</td>
			</tr>
		</table>
	</div>
</body>
</html>