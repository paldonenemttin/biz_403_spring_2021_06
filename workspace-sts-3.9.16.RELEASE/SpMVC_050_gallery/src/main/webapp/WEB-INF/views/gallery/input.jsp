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
</style>
<form
	method="POST"
	enctype="multipart/form-data">
	<div class="all">
		<div class="au_date">
			<div>
				<label>작성자</label>
				<input
					name="g_writer"
					value="${CMD.g_writer}" type="hidden">
					<p>${CMD.g_writer}</p>
			</div>
			<div>
				<label>작성일자</label>
				<input
					name="g_date"
					value="${CMD.g_date}" type="hidden">
					<p>${CMD.g_date}</p>
			</div>
			<div>
				<label>작성시간</label>
				<input
					name="g_time"
					value="${CMD.g_time}" type="hidden">
					<p>${CMD.g_time}</p>
			</div>
		</div>

		<div class="title">
			<label>제목</label>
			<input name="g_subject">
		</div>
		<div class="content">
			<label></label>
			<textarea name="g_content"></textarea>
		</div>
	</div>
	<div class="input_img">
		<div>
			<label>대표이미지</label>
			<input
				type="file"
				name="one_file">
		</div>
		<div>
			<label>갤러리</label>
			<input
				type="file"
				name="m_file"
				multiple="multiple">
		</div>
	</div>
	<button>전송</button>
</form>
