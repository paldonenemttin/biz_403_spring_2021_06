<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<h2>성적 정보 리스트</h2>

	<table>
		<tr>
			<th>학번</th>
			<th>이름</th>
			<th>과목코드</th>
			<th>과목명</th>
			<th>성적</th>
		</tr>
		<c:choose>
			<c:when test="${empty SCORES}">
				<tr>
					<td colspan="3">데이터가 없음</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${SCORES}" var="SCORE" varStatus="seq">
					<tr>
						<td>${SCORE.sc_stnum}</td>
						<td>이름</td>
						<td>${SCORE.sc_sbcode}</td>
						<td>과목명</td>
						<td class="number">${SCORE.sc_score}</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
	<div class="btn_box">
		<button class="score insert">성적등록</button>
		<button class="score student list">학생정보 바로가기</button>
	</div>
