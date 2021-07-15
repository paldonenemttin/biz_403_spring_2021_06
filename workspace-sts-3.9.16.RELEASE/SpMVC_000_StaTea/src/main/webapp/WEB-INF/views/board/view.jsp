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
<title>Insert title here</title>
<link
	href="${rootPath}/static/css/freeview.css?ver=2021-06-15-004"
	rel="stylesheet" />
</head>
<body>
	<div id="view_tit">

		<p id="title">자유게시판 게시물</p>
	</div>
	<div class="state">
		<table>
			<tr>
				<td colspan="5">${BVIEWS.bd_title}</td>
			</tr>
			<tr>
				<th id="th_author">작성자</th>
				<th id="th_avo">추천수</th>
				<th id="th_date">조회수</th>
				<th id="th_time">작성시간</th>
			</tr>
			<tr>
				<td id="td_author">${BVIEWS.bd_user}</td>
				<td id="td_avo">${BVIEWS.bd_like}</td>
				<td id="td_date">${BVIEWS.bd_vcount}</td>
				<td id="td_time">${BVIEWS.bd_time}</td>
			</tr>
		</table>
	</div>
	<div class="main_cont">
		<p id="content">${BVIEWS.bd_content}</p>
		<div>
			<c:forEach
				items="${BVIEWS.imgList}"
				var="image">
				<c:if test="${not empty image.img_upname}">
					<img
						src="${rootPath}/board/view/statea/${image.img_upname}"
						height="200px">
				</c:if>
			</c:forEach>
		</div>
	</div>
	<form>
		<div id="like_box">
			<p></p>
			<input
				type="hidden"
				name="like_user">
			<input
				type="hidden"
				name="like_cncode">
			<button id="like">추천</button>
		</div>
	</form>
	<div class="btn_avo_list">
		<button
			id="list"
			onclick="location.href='/statea/board/list'">목록으로</button>
		<button id="update">수정</button>
		<button id="delete">삭제</button>
		<!--
		회원 기능 생길시 사용할 코드 
		<c:if test="${USER.user_id == USER.user_id}">
			<button id="update">수정</button>
			<button id="delete">삭제</button>
		</c:if>
		 -->
	</div>

</body>
<script>
      
    document.querySelector("#delete").addEventListener("click",(e)=>{
    	if(confirm("해당 게시물을 삭제합니다")){
    		location.replace("${rootPath}/board/delete?bd_code=${BVIEWS.bd_code}")
    	}
    })
    
    document.querySelector("#update").addEventListener("click",(e)=>{
    	location.href= "${rootPath}/board/update/${BVIEWS.bd_code}" 
    })
    
    document.querySelector("#like").addEventListener("click",(e)=>{
    	let user = document.querySelector("input[name='like_user']").value
    	let cncode = document.querySelector("input[name='like_cncode']").value
    	
    	fetch("${rootPath}/board/like/${BVIEW.bd_code}",{
    		method: "POST",
    		body: jsonString,
    		headers : {
    			"content-Type" : "application/json"
    		}	
    	})
    	.then(response=>response.text())
    	.then(result=>{
    		if(result === "LIKE"){
    			
    		}
    
    	
    		
    	})
    });
    
        
        
  </script>
</html>