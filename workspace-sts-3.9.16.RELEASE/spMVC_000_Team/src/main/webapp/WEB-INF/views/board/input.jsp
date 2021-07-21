<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<style>

div.input {
	margin-bottom: 200px;
}

div.tit_con {
	display: flex;
	flex-wrap: wrap;
	margin-top: 10px;
	justify-content: center;
}

div.button {
	margin-top: 10px;
	margin-left: 5%;
	width: 90%;
}

div.under {
	display: flex;
	justify-content: space-between;
}

input#title {
	width: 90%;
	padding:4px 4px;
	font-size: 20px;
	margin-top:10px;
	margin-bottom: 20px;
	height: 50px;
}

textarea#box {
	padding: 5px 5px;
	width: 90%;
	height: 700px;
	font-size: 20px;
	resize: none;
	/*자동 스크롤*/
	overflow: auto;
}

button#save {
	padding: 8px 19px;
	background-color: rgb(3, 102, 53);
	color: white;
	border: none;
	border-radius: 5px;
	font-size: 20px;
	height: 40px;
	margin-top: 5px;
}

button#save:hover {
	cursor: pointer;
	padding: 5px 19px;
	background-color: rgb(68, 32, 32);
	color: white;
	border: none;
	border-radius: 5px;
	font-size: 20px;
	box-shadow: 1px 1px 1px gray;
}

input#image {
	font-size: 20px;
	height: 40px;
}

div.img_box {
	margin-top: 14px;
	border: 1px solid black;
	width: 90%;
	height: 300px;
	justify-content: center;
	background-color: #ddd;
	border-style: none;
	margin-left:5%;
}
p#img_delete:hover{
	cursor: pointer;
}

</style>

<meta charset="UTF-8">
<title>글 작성 페이지</title>
</head>
<body>
	<form method="POST" enctype="multipart/form-data">
		<div class="input">
			<div class="tit_con">
				<input id="code" type="hidden" name="bd_code"
					value="${FREE.bd_code}"> <input id="title" type="text"
					name="bd_title" placeholder="제목은 반드시 입력하세요" value="${FREE.bd_title}" />
				<input id="id" type="hidden" name="bd_user" value="${LOGIN.user_id}">
				<input id="time" type="hidden" name="bd_time"
					value="${FREE.bd_time}" />
				<textarea id="box" name="bd_content" placeholder="내용을 입력하세요">${FREE.bd_content}</textarea>
			</div>
			<div class="button">
				<div class="under">
					<!--파일 업로드-->
					<input id="image" multiple="multiple" type="file" name="m_file" />
					<button id="save">저장</button>
				</div>
			</div>
			<div class="img_box">
				<div id="img_con">
					<c:forEach items="${FREE.imgList}" var="image">
						<div class="image_file" data-icode="${image.img_code}">
							<c:if test="${not empty image.img_upname}">
								<p id="img_delete">${image.img_origin}</p>
							</c:if>
						</div>
					</c:forEach>
				</div>
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
			if(confirm("정말로 삭제합니까?")){
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