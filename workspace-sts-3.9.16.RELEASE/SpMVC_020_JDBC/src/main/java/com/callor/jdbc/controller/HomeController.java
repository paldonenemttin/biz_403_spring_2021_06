package com.callor.jdbc.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.jdbc.pesistance.BookDao;
import com.callor.jdbc.pesistance.CompDao;
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
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		log.debug("user_Email : {}", user_email);
		log.debug("user_name : {}",user_name);
		rentService.viewBookAndComp();
		return "home";
	}
	
}
