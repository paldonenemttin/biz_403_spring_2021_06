<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생정보입력</title>
</head>
<body>
	<form method=POST>
		<fieldset>
			<legend>학생정보</legend>
			<div>
				<label>학번</label><input name="st_code" id="st_code" />
			</div>
			<div>
				<label>전공</label><input name="st_spec" id="st_spec" />
			</div>
			<div>
				<label>이름</label><input name="st_name" id="st_name" />
			</div>
			<div>
				<label>학년</label><input name="st_grade" id="st_grade" />
			</div>
			<div>
				<label>전화번호</label><input name="st_tel" id="st_tel" />
			</div>
			<div>
				<label>주소</label><input name="st_addr" id="st_addr" />
			</div>
			<div class="btn_box">
				<button type="button" class="btn_save">저장</button>
				<button type="reset" class="btn_reset">새로작성</button>
				<button type="button" class="btn_list">리스트로</button>
			</div>
		</fieldset>
	</form>
</body>
</html>