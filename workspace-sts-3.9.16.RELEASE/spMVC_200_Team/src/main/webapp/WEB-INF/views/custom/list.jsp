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
#custom {
	padding: 0;
	margin: 20px auto;
	width: 100%;
	border: 1px solid transparent;
}

#customlist {
	display: flex;
	margin: 19px auto;
	padding: 0;
	justify-content: center;
}

#customTr {
	margin: 30px auto;
	margin-bottom: 100px;
}

#customlist td {
	margin: 10px;
	display: flex;
	font-size: 50px;
	font-weight: 400;
}

#customlist td:nth-of-type(1) {
	margin-top: 80px;
}

#last {
	border-bottom: 1px double #aaa;
	padding-bottom: 70px;
}

#customlist img {
	display: inline-block;
	border-radius: 30px;
	width: 800px;
	margin: 0 auto;
}

h3:before {
	content: ' \2730';
	color: green;
	font-size: 100px;
}
</style>
<%@ include file="/WEB-INF/views/include/search.jsp" %>
<fieldset id="custom">
	<table id="customlist">
		<c:choose>
			<c:when test="${empty CustomList}">
				<td colspan="5">데이터없음</td>
			</c:when>
			<c:otherwise>
				<c:forEach
					items="${CustomList}"
					var="CUS">
					<tr id="customTr">
						<td><h3>${CUS.user_id}</h3></td>
						<td id="img"><img src="${rootPath}/files/${CUS.file_upname}"></td>
						<td>메뉴 제목 	: ${CUS.menu_title}</td>
						<td>퍼스널 옵션 :${CUS.menu_option}</td>
						<td id="last">메뉴종류 : ${CUS.menu_name}</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
</fieldset>
