<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<style>
* {
	box-sizing: border-box;
	width: 345px;
}

html, body {
	height: 100%;
	width: 100%;
}

/* 검색창 */
div.ser_title {
	display: flex;
	align-items: center;
	justify-content: center;
	margin-top:-28px;
	position: fixed;
}

div.main {
	margin-top: 30px;
}

input#search {
	font-size: 10px;
	height: 20px;
	width: 150vh;
}

i {
	font-size: 20px;
}

a {
	text-decoration: none;
}

a:hover {
	cursor: pointer;
}

/* 버튼 */
button {
	padding: 5px 3px;
	background-color: rgb(3, 102, 53);
	color: white;
	border: none;
	border-radius: 5px;
	font-size: 3px;
	margin-bottom: 5px;
	width:120px;
}

button#sear_click {
	font-size: 5px;
	margin-left: 8px;
	margin-right: 8px;
}

div#list {
	display: flex;
	font-size: 3px;
}

div#title {
	border: 1px solid black;
	font-size: 5px;
	width: 100%;
	text-overflow: ellipsis;
	overflow: hidden;
}

div#hitid {
	border: 1px solid black;
	display: flex;
	width: 100%;
}

div#time {
	border: 1px solid black;
	width: 18%;
	font-size: 5px;
	white-space: normal;
}

div#hitid p {
	font-size: 0.5px;
}

p{
margin-left: 5px;
}
</style>
<script src="https://kit.fontawesome.com/7f8ef4d19e.js"
	crossorigin="anonymous"></script>
<body>
	<div class="ser_title">
		<i class="fas fa-search"></i> <input id="search" type="text"
			placeholder="키워드를 입력하세요" />
		<button id="sear_click">검색</button>
		<button id="write" onclick="location.href='${rootPath}/board/input'"
				value="글쓰기">글쓰기</button>
	</div>
	<div class="main">
		<div class="all_list">
			<c:choose>
				<c:when test="${empty BOARDS}">
					<tr>
						<td colspan="6">데이터 없음</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach items="${BOARDS}" var="board">

						<div id="list">
							<div id="title">
								<p>
									<a href="${rootPath}/board/view/${board.bd_code}">${board.bd_title}</a>
								</p>
								<div id="hitid">
									<p>작성자:${board.bd_user}</p>
									<p>조회수:${board.bd_vcount}</p>
								</div>
							</div>
							<div id="time">
								<p id="emit">${board.bd_time}</p>
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
    alert("작성 페이지로 이동합니다.");
});

</script>
</html>