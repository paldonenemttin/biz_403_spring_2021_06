package com.callor.jdbc.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.jdbc.service.RentService;

import lombok.extern.slf4j.Slf4j;

/**
 * Handles requests for the application home page.
 */
@Slf4j
@Controller
public class HomeController {
	
	// string.properties 파일에 설정된 속성값 가져와서 변수에 세팅
	@Value("${user.name}")
	protected String user_name;
	@Value("${user.email}")
	protected String user_email;
	/*
	 * 보편적인 스프링에서 bean를 사용하는 코드
	 * @Autowired
	 * private BookDao bookDao
	 * 이 코드에서 메모리 leak(누수)현상이 보고되어
	 * 다음의 코드를 권장한다
	 */
	//protected final BookDao bookDao;
	//protected final CompDao compDao;
	
	protected final RentService rentService;
	public HomeController(RentService rentService) {
		// TODO Auto-generated constructor stub
		this.rentService = rentService;
	}
	
	/*
	 * 사용자에게 Response를 할때
	 * forward방법과 redirect방법이 있다
	 * 
	 *  forwarding은
	 *  service 등등에서 생성한(조회한) 데이터를
	 *  *.jsp 파일과 rendering하여 사용자에게 HTML코드로 전송한다
	 *  
	 *  service등등에서 
	 *  
	 *  class Spring___{
	 *  	main(){
	 *          HomeController hConroller = new HomeController();
	 *  		Locale locale - new Locale();
	 *  		Model model = new Model();
	 *  		hController.home(locale, model);
	 *  		
	 *  		if(! url.contains("redirect")){
	 *  		  rendering(url, model);
	 *  		}
	 *  		
	 *  	}
	 *  }
	 */
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
	
		/*
		 * 매개변수로 전달받은 model class type변수인 Model에
		 * 속성을 하나 추가한다.
		 * 속성의 이름은 user이며 값은 user_name의 담긴 값이다
		 * 
		 * Model객체에 담긴 속성(변수)들은  Rendering이 완료되면 메모리에서 삭제된다
		 */
		
		model.addAttribute("user",user_name);
		rentService.viewBookAndComp();
		return "home";
	}
	
}
