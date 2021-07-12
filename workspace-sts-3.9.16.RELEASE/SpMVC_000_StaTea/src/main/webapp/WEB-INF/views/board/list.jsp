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
<link
	href="${rootPath}/static/css/freeboard.css?ver=2021-07-12-002"
	rel="stylesheet" />
<script
	src="https://kit.fontawesome.com/7f8ef4d19e.js"
	crossorigin="anonymous"></script>
<body>
	<h2>자유게시판</h2>
	<div class="main">
		<div class="btn_writ">
			<button
				id="write"
				onclick="location.href='${rootPath}/board/input'"
				value="글쓰기">글쓰기</button>
		</div>
		<div class="all_table">
			<table>
				<tr class="table">
					<th id="th_no">번호</th>
					<th id="th_title">제목</th>
					<th id="th_au">작성자</th>
					<th id="th_avo">추천수</th>
					<th id="th_vcount">조회수</th>
					<th id="th_date">작성일</th>
				</tr>
				<c:choose>
					<c:when test="${empty BOARDS}">
						<tr>
							<td colspan="6">데이터 없음</td>
						</tr>
					</c:when>
					<c:otherwise>
						<c:forEach
							items="${BOARDS}"
							var="board">
							<tr class="value">
								<td id="td_no">${board.bd_code}</td>
								<td id="td_title"><a
									href="${rootPath}/board/view/${board.bd_code}">${board.bd_title}</a></td>
								<td id="td_au">${board.bd_user}</td>
								<td id="td_avo">${board.bd_like}</td>
								<td id="td_vcount">${board.bd_vcount}</td>
								<td id="td_date">${board.bd_time}</td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</table>
		</div>
		<div class="ser_title">
			<i class="fas fa-search"></i>
			<input
				id="search"
				type="text"
				placeholder="키워드를 입력하세요" />
			<button id="sear_click">검색</button>
		</div>
	</div>
</body>
<script type="text/javascript">
document.querySelector("#write").addEventListener("click",(e)=>{
    alert("작성 페이지로 이동합니다.");
});
</script>
</html>