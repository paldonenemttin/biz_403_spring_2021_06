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
		div.msg{
		font-size: 10px;
		color: red;
	}
		
	</style>
<form method="POST">
	<div>
		<label>사용자 ID{email}</label>
		<input name="m_userid" type="email" id="m_userid">
		<div class="msg join id">	
		</div>
	</div>
	<div>
		<label>비밀번호</label>
		<input name="m_password">
	</div>
	<div>
		<label>비밀번호 확인</label>
		<input name="re_password">
	</div>
	<div>
		<label>닉네임</label>
		<input name="m_nick">
	</div>
	<div>
		<label>전화번호</label>
		<input name="m_tel">
	</div>
	<div>
		<button>가입신청</button>
	</div>
</form>
<script>
					// id가 있으면 ("input#user_id")
	let user_id = document.querySelector("input[name='m_userid']")
	let msg_user_id = document.querySelector("div.join.id") 
	if(user_id){
		
		// lost focus
		// input tag에 입력하는 도중 다른 tag로 focus기 이동하는 경우 
		// blur, focusout event 코드에서
		// alert를 사용하면 Lost focus와 alert 사이에서 무한 반복이 일어나는
		// 현상 발생
		// lost focus가 되었을때 메시지를 사용자에게 보이고 싶을땐
		// alert를 사용 않고 다른 방법을 찾아야 함
		// 비어있는 div box를 만들고 그곳에 메시지를 표시하는 방법을 사용한 것
		user_id.addEventListener("blur", (e)=>{
			let m_userid = e.currentTarget.value
			
			msg_user_innerText = "";
			msg_user_id.style.padding = "0"
			
			// m.userid box에 사용자 id를 입력한 상태로
			// tab을 누르거나 다른 값을 입력하기 위해
			// focus를 이동하면
			// m.userid box에 입력된 값으로 id 중복 검사를 수행하기
			if(m_userid === ""){
				msg_user_id.innerText = "* 사용자 아이디는 반드시 입력"
				msg_user_id.style.padding = "5px"
				user_id.focus()
				return false
			}
			
			//href와 유사
			fetch("${rootPath}/member/id_check?m_userid=" + m_userid)
			//.then((response)=>{
				//return response.text()
			//})
			.then(response=>response.text()).then(result=>{
				if(result === "USE_ID"){
					msg_user_id.innerText = "* 이미 가입된 id입니다"
					user_id.focus
					return false
				} else if(result === "NOT_USE_ID"){
					msg_user_id.innerText = "* 사용가능한 id입니다"
					msg_user_id.style.color = "blue"
					
					document.querySelector("input[name='m_userid']").focus()
				} else{
					msg_user_id.innerText = "* 알 수 없는 결과입니다"
				}
			})
		})
	}
</script>