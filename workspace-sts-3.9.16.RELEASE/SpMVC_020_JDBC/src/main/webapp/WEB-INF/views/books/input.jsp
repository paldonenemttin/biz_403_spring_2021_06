<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<%@ include file="/WEB-INF/views/include/head.jspf"%>
<style>
from#book_input input.search {
	width: 30%;
}

sman.name {
	color: blue;
	font-weight: bold;
	margin-left: 10px;
}
</style>
<script src="${rootPath}/static/js/book_input.js?ver=2021-06-21-010"></script>
<script type="text/javascript">
	var rootPath = "${rootPath}";
</script>
<body>
	<%@ include file="/WEB-INF/views/include/include_header.jspf"%>

	<form id="book_input" method="POST">
		<fieldset>
			<legend>도서정보 등록</legend>
			<div>
				<label>ISBN</label> <input name="bk_isbn" id="bk_isbn"
					placeholder="">
			</div>
			<div>
				<label>도서명</label> <input name="bk_title" id="bk_title"
					placeholder="">
			</div>
			<div>
				<label>출판사</label> <input class="search" name="bk_ccode"
					id="bk_ccode" placeholder=""> <span id="cp_title"
					class="name">출판사명</span>
			</div>
			<div>
				<label>저자</label> <input class="search" name="bk_acode"
					id="bk_acode" placeholder=""> <span id="cp_author"
					class="name">저자명</span>
			</div>
			<div>
				<label>출판년도</label> <input name="bk_date" id="bk_date"
					placeholder="">
			</div>
			<div>
				<label>가격</label> <input name="bk_price" id="bk_price" value="0"
					placeholder="">
			</div>
			<div>
				<label>페이지수</label> <input name="bk_pages" id="bk_pages" value="0"
					placeholder="">
			</div>
		</fieldset>
		<div class="btn_box">
			<button type="button" class="btn_save book">저장</button>
			<button type="reset" class="btn_reset book">새로작성</button>
			<button type="button" class="btn_list book">리스트로</button>
		</div>
	</form>
	<%@ include file="/WEB-INF/views/include/include_footer.jspf"%>


</body>

<script>

/*
 동적으로 (fetch로 가져온 html)만들어진 DOM에 event 설정하기
 표준 js에서는 동적으로 생성된tag는 document.querySelector()에 의해
 선택되지 않는다 이벤트를 document(가장 상위 DOM)에 설정하기
 */
document.addEventListener("click",(e)=>{
		let target = e.target
		let tagName = target.tagName
		if(tagName === "TD"){
			let parentTag = target.closest("TR");
			let parentClass = parentTag.className
			if(parentClassName === "search_comp"){
				//let ccode = parentTag.dataset.ccode
				
				// 현재선택된 tr의 child를 가져와서
				// 각 td갈럼에 담겨 있는 값을 추출하기
				let tds = parentTag.childNodes
				let ccode = tds[1].textContent
				let ctitle = tds[2].textContent
				let cceo = tds[3].textContent
				let ctel = tds[4].textContent
				
				let msg = ctitle + ",";
				msg += cceo + ",";
				msg += ctel + ",";
				alert("출판사 코드: " + ccode + ":" + ctitle);
				document.querySelector("input#bk_ccode").value = ccode
				document.querySelector("span#cp_title").innerTEXT = ctitle
			} else if(parentClassName === "search_author"){
				//let acode = parentTag.dataset.acode
				let tds = parentTag.childNodes
				let acode = tds[1].textContent
				let aname= tds[3].textContent
				let atel = tds[5].textContent
				let msg = aname + ",";
				msg += atel + ",";
				document.querySelector("input#au_acode").value = acode
				document.querySelector("span#au_name").innerTEXT = msg
			}
			
			document.querySelector("div.modal").style.display = "none"
			document.querySelector("div#div_search").innerHTML = ""
			document.querySelector("div#div_search").remove();
		}
});
</script>

</html>