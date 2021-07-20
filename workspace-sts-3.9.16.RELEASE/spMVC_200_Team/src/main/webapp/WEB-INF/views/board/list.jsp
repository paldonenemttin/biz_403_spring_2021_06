<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<style>
body {
	background-color: whitesmoke;
}
/* 검색창 */
div.ser_title {
	display: flex;
	border: 1px solid black;
	position: fixed;
	display: flex;
	width: 100%;
	margin-top: -60px;
	justify-content: center;
	margin-left: -9px;
}

div.main {
	margin-top: 60px;
	justify-content: center;
}

input#search {
	font-size: 20px;
	height: 40px;
	width: 20vh;
	margin-top: 10px;
}

a {
	text-decoration: none;
}

a:hover {
	cursor: pointer;
}

/* 버튼 */
button {
	margin-top: 3px;
	padding: 15px 10px;
	background-color: rgb(3, 102, 53);
	color: white;
	border: none;
	border-radius: 5px;
	font-size: 15px;
	margin-bottom: 5px;
	width: 100px;
}

button#sear_click {
	margin-left: 8px;
	margin-right: 8px;
}

div.bd_list {
	border: 1px solid black;
	display: flex;
	font-size: 20px;
	border-top-style: none;
	border-left-style: none;
	border-right-style: none;
}

div.bd_con {
	width: 90%;
	margin-left: -8px;
}

div#bd_title {
	border: 1px solid black;
	height: 40px;
	padding: 10px 20px;
}

div#bd_hitid {
	display: flex;
	margin-top: 20px;
}

div#bd_time {
	border: 1px solid black;
	padding-right: 10px;
	padding-left: 10px;
	width: 20%;
	height: 8px;
	padding-left: 10px;
}

div#bd_hitid p {
	font-size: 5px;
}

div#bd_time p {
	margin-top: 50px;
}

div#bd_title p {
	display: block;
	white-space: nowrap;
	overflow: hidden;
	text-overflow: ellipsis;
	margin-left: 5px;
	margin-top: -0.1px;
}

p {
	margin-left: 20px;
}
</style>
<body>

	<div class="main">
		<div class="ser_title">
			<input id="search" type="text" placeholder="키워드를 입력하세요" />
			<button id="sear_click">검색</button>
			<c:if test="${not empty USER.user_id}">
				<button id="write" onclick="location.href='${rootPath}/board/input'"
					value="글쓰기">글쓰기</button>
			</c:if>
		</div>
		<div class="all_list">
			<c:choose>
				<c:when test="${empty BOARDS}">
					<tr>
						<td colspan="6">데이터 없음</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach items="${BOARDS}" var="board">

						<div class="bd_list">
							<div class="bd_con">
								<div id="bd_title">
									<p>
										<a href="${rootPath}/board/view/${board.bd_code}">${board.bd_title}</a>
									</p>
								</div>
								<div id="bd_hitid">
									<p>작성자:${board.bd_user}</p>
									<p>조회수:${board.bd_vcount}</p>
								</div>
							</div>
							<div id="bd_time">
								<p>${board.bd_time}</p>
							</div>
						</div>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</body>
<script type="text/javascript">
document.querySelector("#write").addEventListener("click",(e)=>{
    alert("작성 페이지로 이동합니다.")
})



</script>
</html>