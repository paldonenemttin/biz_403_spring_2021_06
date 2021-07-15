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
section.page_box {
	width: 80;
	margin: 10px auto;
	display: flex;
	justify-content: center;
	align-items: center
}

section.page_box ul {
	width: 80;
	display: flex;
	list-style: none;
}

section.page_box li {
	display: inline-block;
	border: 1px solid rgbd(0, 0, 225, 0.7);
	line-height: 1.25;
	text-align: center;
	padding: 0.5rem 1rem;
	color: #007BFF;
	background-color: #FFF;
	border: 1px solid #DEE2E6;
	cursor: pointer;
}

section.page_box li:hover {
	color: #005683;
	background-color: #E9ECEF;
	border-color: #DEE2E6;
	font-weight: 400;
}

section.page_box li:actice {
	color: #FFF;
	background-color: #007BFF;
	border-color: #007BFF;
}
</style>
<section class="page_box">
	<ul class="page_nav_main">
		<li data-num="1">| &lt;</li>
		<li data-num="${PAGE_NUM - 1}">&lt;</li>
		<c:if test="${PAGE_NAV.starPage > 2}">
			<li>......</li>
		</c:if>
		<c:forEach
			begin="${PAGE_NAV.startPage}"
			end="${PAGE_NAV.endPage}"
			var="pageNum">
			<li
				data-num="${pageNum}"
				class="
				<c:if test="${PAGE_NUM == pageNum}">active</c:if>">${pageNum}</li>
		</c:forEach>
		<c:if test="${PAGE_NAV.endPage < PAGE_NAV.totalPages}">
			<li>......</li>
		</c:if>
		<li data-num="${PAGE_NUM  + 1}">&gt;</li>
	</ul>
</section>
<script>
	const page_nav_mian = document.querySelector("ul.page_nav_main")
	if(page_nav_main){
		page_nav_main.addEventListener("click", ()=>{
			const li = e.target
			if(li.tagName === "LI"){
				const pageNum = e.target.dataset.num
				location.href = "${rootPath}/gallery?pageNum=" + pageNum
			}
		})
	}
</script>