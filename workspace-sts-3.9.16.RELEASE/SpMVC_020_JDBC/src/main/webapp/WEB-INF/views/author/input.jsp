<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나의 홈페이지</title>
</head>
<body>
	<h1>출판사 정보 등록</h1>
	<form method=POST>
	<fieldset>
	<legend>저자 정보</legend>
		<div>
			<label>출판사명</label><input name="cp_title" id="cp_title"/>
		</div>
		<div>
			<label>대표자명</label><input name="cp_ceo" id="cp_ceo"/>
		</div>
		<div>
			<label>전화번호</label><input name="cp_tel" id="cp_tel" />
		</div>
		<div>
			<label>주소</label><input name="cp_addr" id="cp_addr" />
		</div>
		<div><label>주요장르</label><input name="cp_genre" id="cp_genre"/></div>
		<div class="btn_box">
			<button type="button" class="btn_save author">저장</button>
			<button type="reset" class="btn_reset author">새로작성</button>
			<button type="button" class="btn_list author">리스트로</button>
		</div>
		</fieldset>
	</form>
	
	<script>
	const doc = document;
	doc.querySelector("button.btn_delete").addEventListener("click",(e)=>{
		doc.querySelector("input[name='cpcode']")
			const cpcodeObj = doc
							.querySelector("input#cpcode")
							
			let cpcode = cpcodeObj.value
			if(confirm(cpcode + " 를 삭제합니다!!")) {
				location.replace(
					"${rootPath}/comp/delete?cp_code=" + cpcode
				);
			}
	})
			
</script>
</body>
</html>