<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://kit.fontawesome.com/7f8ef4d19e.js"
	crossorigin="anonymous"></script>
	<style type="text/css">
	h2{
        margin-top: 30px;
        padding-left: 10%;
      }
      /* 검색창 */
      div.ser_title{
        display: flex;
        margin-left: 25%;
        margin-bottom: 10px;
        margin-top: 30px;
      }
      input#search{
        height: 23px;
        width: 400px;
      }
      i{
        margin-top: 2px;
        margin-right: 5px;
        font-size: 25px;
      }
      /* 게시물 표 */
      table {
        margin: auto;
        border-collapse: collapse;
        border-spacing: 0;
        width: 80%;
      }
      table th, td {
        border: 1px solid #aaa;
        padding: 5px 8px;
        height: 10px;
        font-size: 12px;
      }
      tr.value:hover{
        cursor: pointer;
        background-color: #F2F5F4;
        transition: background-color 0.2s;
      }
      td{
        text-align: center;
      }
      th#au,td#au{
        width:10px;
      }
      th#date,td#date{
        width: 10px;
      }
      th#time,td#time{
        width: 10px;
      }
      th#title,th#title{
        width: 100px;
      }
      th#no,td#no{
        width:10px;
      }
      th#avo,td#avo{
        width: 10px;
      }
      th:first-child, th:last-child, td:first-child, td:last-child{
        border-left: none;
        border-right: none;
      }
      /* 버튼 */
      button {
        padding: 7px 20px;
        background-color: green;
        color: white;
        border: none;
        border-radius: 2px;
        font-size: 15px;
        transition: background-color 0.3s;
      }
          
      button:hover {
        padding: 7px 20px;
        background-color: rgb(68, 32, 32);
        color: white;
        border: none;
        border-radius: 2px;
        font-size: 15px;
        transition: background-color 0.3s;
        cursor:pointer;
      }
      button#write{
        margin-left: 80%;
        margin-top: 5px;
        font-size: 12px;
      }
       button#sear_click{
         font-size: 12px;
         margin-left: 8px;
       }
	</style>
</head>
<body>

	<h2>자유게시판</h2>
	<hr></hr>
	<div class="ser_title">
		<i class="fas fa-search"></i> <input id="search" type="text"
			placeholder="키워드를 입력하세요" />
		<button id="sear_click">검색</button>
	</div>
	<div>
		<table>
			<tr class="table">
				<th id="no">번호</th>
				<th id="title">제목</th>
				<th id="avo">추천수</th>
				<th id="au">작성자</th>
				<th id="date">작성일</th>
				<th id="time">작성시간</th>
			</tr>
			<tr class="value">
				<td id="no">1</td>
				<td id="title">1</td>
				<td id="avo">0</td>
				<td id="au">아무개</td>
				<td id="date">2021-06-11</td>
				<td id="time">14:40:23</td>
			</tr>
		</table>
	</div>
	<div class="btn_writ">
		<button id="write" type="button" onclick="location.href='input'">글쓰기</button>
	</div>
</body>
</html>