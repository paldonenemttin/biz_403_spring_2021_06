package com.callor.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyController {
	
	/*
	 * RequestMethod
	 * GET:(SELECT)  조회 - a tag의 link 클릭
	 * POST:(INSERT) 추가 - form에 값을 입력하여 서버로 보낼때
	 * 
	 * RESTfell HTTP Server에서 추가하여 사용
	 * PUT: (UPDATE) 수정
	 * DELETE: (DELETE)삭제
	 * 
	 * RequestMapping이 같고 , requsetMethod가 같은 경우는 절대 허용 않는다
	 * 
	 * requestMapping이 같더라도 RequestMapping이 다르면 같이 사용 할 수 있다.
	 * 
	 * GET method 방식으로 form에 담긴 데이터를 전송할때
	 * http://localhost:8080/hello/insert?name=홍길동&tel=010-2345-6789
	 * - 전송하는 데이터가 HTTP프로토콜의 body에 담겨서
	 * 전송되기 때문에 데이터가 쉽게 노추될 수 있다
	 * - 전체 uri의 길이가 256byte를 넘어가면
	 * 데이터가 자릴는 현상이 발생한다
	 * 
	 * POST method 방식으로 form에 담긴 데이터를 전송할때
	 * http://localhost:8080/hello/insert
	 * - 전송하는 데이터가 http프로토콜의 body에 담겨서 전송되지 않기 때문에
	 * 주소창등에 노출되지 않는다
	 * - 이론상으로는 전송하는 데이터의 크기에 제한이 없다
	 * 다만, 이미지와 같이 큰 데이터를 전송하게 되면
	 * 네트워크에 문제가 달생할 수 있어서 설정에서 일부 크기를 제한하기도 한다
	 * 
	 * 서버 입장에서
	 * GET : http://localhost:8080/hello/insert?name=""으로 요청을 받으면
	 * @RequestMapping(value = "/insert" , method = GET)를 처리하는 method가 있어야 ㅎ나다
	 * 
	 * Mapping(value = "/insert")가 있는데
	 * method=post만 있을 경우 서버는 405 http 상태코드를 응답한다
	 */
	
	
	@RequestMapping(value = "/" , method = RequestMethod.POST)
	public void my() {
		
	}
	
	// insert uri mapping을 post방식으로 요청을 처리 하겠다
	@RequestMapping(value = "/insert" , method = RequestMethod.POST)
	public void insert() {
		
	}
	
	/*
	 * Spring에서는 Web으로부터 전달받은 데이터를 Java method의 매개변수를 설정하여 받을 수 있다
	 * 
	 * String framework 내부에서 reflection이라는 코드가 작동되어서
	 * 전달받은 변수 이름과 java method의 매개변수와 이름매칭 방법으로 변수를 받는다
	 * 이런 코드는 개발자가 신경쓰지 않아도 자동으로 작동된느 코드
	 * getParameter()등의 코드를 이제는 잊어도 된다
	 * 
	 * 그런데,
	 * Java method 변수를 String형이 아닌 것으로 숫자형 boolean형등
	 * 설정을 하면 reflection이 실행된느 동안에 String 형 데이터를
	 * 설정된 데이터 타입으로 형 변환 과정이 실행된다
	 * 이과정에서 형변환의 Exception이 발생하면
	 * Reflection 코드가 중단되고
	 * Spring Dispatcher는  Web 400 Status code를 응답해버린다
	 * 
	 * 또한 구체적으로 어떤 문제가 발생했는지 알려주지 않는다
	 */
	// insert uri mapping을 get방식으로 요청을 처리 하겠다
	@RequestMapping(value = "/insert" , method = RequestMethod.GET)
	public void insert(String dummy, int num) {
		
		Integer.valueOf(dummy);
//		String strNum = "300A";
//		// NumberFormat Exception
//		Integer intNum = Integer.valueOf(strNum);
	}

}
