<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>성적 입력</title>
</head>
<body>
	<form method=POST>
		<fieldset>
			<legend>성적정보 입력</legend>
			<div>
				<label>학번</label><input name="sc_stcode" id="sc_stcode" />
			</div>
			<div>
				<label>국어</label><input name="sc_kor" id="sc_kor" />
			</div>
			<div>
				<label>영어</label><input name="sc_eng" id="sc_eng" />
			</div>
			<div>
				<label>수학</label><input name="sc_math" id="sc_math" />
			</div>
			<div>
				<label>윤리</label><input name="sc_ethi" id="sc_ethi" />
			</div>
			<div>
				<label>지리</label><input name="sc_geo" id="sc_geo" />
			</div>
			<div>
				<label>회계</label><input name="sc_acc" id="sc_acc" />
			</div>
			<div>
				<label>위생</label><input name="sc_hygi" id="sc_hygi" />
			</div>
			<div>
				<label>정보</label><input name="sc_info" id="sc_info" />
			</div>
			<div>
				<label>총점</label><input name="sc_all" id="sc_all" />
			</div>
			<div>
				<label>평균</label><input name="sc_float" id="sc_float" />
			</div>
			<div>
				<label>응시한 과목 갯수</label><input name="sc_count" id="sc_count" />
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