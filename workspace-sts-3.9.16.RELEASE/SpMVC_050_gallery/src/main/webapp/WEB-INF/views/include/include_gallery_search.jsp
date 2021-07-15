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
	section#search_box{
	width: 90%;
	margin: 10px auto;
	}
	form#gallery_search{
		border: 0;
		background-color: rgba(0,225,0,0.6);
		padding:5px;
		display: flex;
		border-radius: 5px;
		justify-content: center;
	}
	form#gallery_search input, form#gallery_search select{
		flex: 1;
		outline: 0;
		border: 1px solid #aaa;
		border-radius: 5px;
		padding: 10px;
		margin: 5px;
		font-size: 30px;
	}
	</style>
<section id="search_box">
	<form id="gallery_search">
		<select name="search_column">
			<option value="g_subject">제목 검색</option>
			<option value="g_writer">작성자 검색</option>
			<option value="g_content">내용검색</option>
		</select>
		<input name="search_text" placeholder="검색어를 입력 후 Enter">

	</form>
</section>