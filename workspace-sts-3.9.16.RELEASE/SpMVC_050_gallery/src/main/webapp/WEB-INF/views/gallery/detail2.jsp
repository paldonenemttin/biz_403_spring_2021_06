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
<style>
div#gallery_box {
	width: 90%;
	margin: 10px auto;
	border: 1px solid #aaa;
	display: flex;
}

div#gallery_files {
	width: 90%;
	margin: 10pz auto;
	display: flex;
	border:1px solid black;
	flex-wrap: wrap;
}

div#gallery_files div.gallery_file {
	margin: 2px;
	max-width: 100px;
	overflow: hidden;
	height:200px;
}
div.gallery_file:after{
	content:"삭제";
	position: absolute;
	left:0;
	right:0;
	top:0;
	botton:0;
	background-color: transparent;
	color: transparent;
	transition:0.7s;
	z-index:10;
}
div.gallery_file:hover:after{
	background-color: rgba(0,0,0,3);
	color:white;
	text-align: center;
	vertical-align: middle;
	cursor:pointer;
}

div#gallery_button_box {
	width: 90%;
	margin: 5px auto;
	text-align: right;
	border: 1px solid black;
}

div#gallery_button_box button {
	display: inline-block; padding : 12px 16px;
	outline: 0;
	border: 0;
	border-radius: 10px;
	padding: 12px 16px;
}

div#gallery_button_box:hover {
	box-shadow: 2px 2px 2px #333;
	cursor: pointer;
}

div#gallery_button_box hutton:nth-of-type(1) {
	background-color: blue;
	color: white;
	'
}

div#gallery_button_box hutton:nth-of-type(2) {
	background-color: red;
	color: orange;
}
</style>
<div id="gallery_box">
	<c:if test="${empty file.file_upname}">
		<img
			src="${rootPath}/files/noImage.jpg"
			height="200px">
	</c:if>
	<c:if test="${not empty file.file_upname}">
		<img
			src="${rootPath}/files/${file.file_upname}"
			height="200px">
	</c:if>
</div>
<div id="gallery_info">
	<h3>제목: ${GALLERY.g_subject}</h3>
	<h5>SEQ:${GALLERY.g_seq}</h5>
	<p>작성일: ${GALLERY.g_date}</p>
	<p>작성시각: ${GALLERY.g_time}</p>
	<p>작성자: ${GALLERY.g_writer}</p>

</div>
<div>
	<p>내용: ${GALLERY.g_content}</p>
</div>
<div id="gallery_files">
	<c:forEach
		items="${GALLERY.fileList}"
		var="file">
		<div class="gallery_file" data-fseq="${file.file_seq}">
			<c:if test="${empty file.file_upname}">
				<img
					src="${rootPath}/files/noImage.jpg"
					height="200px">
			</c:if>
			<c:if test="${not empty file.file_upname}">
				<img
					src="${rootPath}/files/${file.file_upname}" >
			</c:if>
		</div>
	</c:forEach>
</div>
<div id="gallery_button_box">
	<button class="gallery update">수정</button>
	<button class="gallery delete">삭제</button>
</div>
<div id="link">
	<a href="${rootPath}/gallery">리스트로</a>
</div>
<script>
	let update_button = document.querySelector("button.gallery.update")
	let delete_button = document.querySelector("button.gallery.delete")
	
 	update_button.addEventListener("click" , ()=>{
 		//alert("${GALLERY.g_seq}인 게시물 수정")
 		/*
 		현재 Gallery.g_seq 값은 숫자형이다
 		만약 Gallery.g_seq 값이 S0001 등과 같이 문자열형이라면 이코드는 문법오류가 발생할 것이다
 		
 		현재 작성한 코드는 jsp코드
 		이 코드는 Response가 될때 html 코드로 변환이 되고
 		script 부분도 변환이 된다
 		
 		아래 코드는 "/rootPath/gallery/update?s_seq=S0001 처럼 변환이 된다
 		변환되는 과정에서 ${GALLERY.g_seq}는 담겨있는 문자열인 S001만 단독으로 나타난다
 		결국 js코드가 실행될때 S0001처럼 벼환되어 변수를 찾게된다
 		그리고 S0001이라는 변수가 정의됮지 않아 문법 오류가 발생한다
 		
 		**el tag를 사용해 스크립트 부분에서 직접 값을 붙일때는 ""를 부착해서 문법 오류를 방지하자
 		*/
 		location.href = "${rootPath}/gallery/update?g_seq=${GALLERY.g_seq}"
 	})
 	delete_button.addEventListener("click",()=>{
 		if(confirm("일련번호 ${gallery.g_seq}인 게시물 삭제 ??")){
 			location.replace("${rootPath}/gallery/delete" + "?g_seq=${GALLERY.g_seq}")
 		}
 	})
 	
 	let gallery_files = document.querySelector("div#gallery_files")
 	if(gallery_files){
 		gallery_files.addEventListener("click", (e)=>{
 			let tag = e.target
 			alert(tag.tagName)
 			if(tag.tagName === "DIV" && tag.className.includes("gallery_file")){
 				let seq - tag.dataset.fseq
 				if(confirm(seq + "이미지 삭제")){
 					fetch("${rootPath}/gallery/file/delete/" + seq)
 					.then(response=>response.text())
 					.then(result=>{
 						if(result === "OK"{
 							alert("삭제성공")
 						})else if(result === "몰라"){
 							alert("서버가 모른대")
 						}else{
 							alert("실패")
 						}
 					})
 				}
 			}
 		})
 	}
</script>