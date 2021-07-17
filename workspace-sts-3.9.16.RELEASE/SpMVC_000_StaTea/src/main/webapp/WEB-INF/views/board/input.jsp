<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<link href="${rootPath}/static/css/input.css?ver=2021-06-14-008"
	rel="stylesheet" />

<meta charset="UTF-8">
<title>글 작성 페이지</title>
</head>
<body>

	<h3>자유게시판 글 작성</h3>
<form method="POST" enctype="multipart/form-data">
	<div class="input">
		<div class="tit_con">
		<input id="code" type="text" name="bd_code" value="${FREE.bd_code}">
			<input id="title" type="text" name="bd_title" placeholder="제목을 입력하세요" value="${FREE.bd_title}"/>
			<input id="id" type="hidden" name="bd_user" value="${USER.user_id}">
			<input id="date" type="hidden" name="bd_time" value="${FREE.bd_time}"/><p>${FREE.bd_time}</p>
			<textarea id="box" name="bd_content" placeholder="내용을 입력하세요">${FREE.bd_content}</textarea>
		</div>
		<div class="under">
			<button id="save">저장</button>
		<!--파일 업로드-->
			<input id="image" multiple="multiple" type="file" name="m_file" />
		</div>
		<div id="img_con">
			<c:forEach
				items="${FREE.imgList}"
				var="image">
				<div class="image_file" data-icode="${image.img_code}">
				<c:if test="${not empty image.img_upname}">
					<p>${image.img_origin}</p>
				</c:if>
				</div>
			</c:forEach>
		</div>
	</div>
	</form>
</body>
<script type="text/javascript">
document.querySelector("#save").addEventListener("click",(e)=>{
    alert("데이터를 저장합니다.");
});
const images = document.querySelector("div#img_con")
if(images){
	images.addEventListener("click", (e)=>{
		if(e.target.tagName === "P" && e.target.parentElement.className.includes("image_file")){
			const code = e.target.parentElement.dataset.icode
			if(confirm(code + "삭제합니까?")){
				fetch("${rootPath}/board/file/delete/" + code)
				.then(response=>response.text())
				.then(result=>{
					if(result === "DROP"){
						alert("삭제합니다")
						e.target.remove()
					}else if( result === "FAIL_CODE"){
						alert("서버에서 응답하지 않습니다")
					}else {
						alert("삭제실패")
					}
				})
			}
		}
	})
}
</script>
</html>