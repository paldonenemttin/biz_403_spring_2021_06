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
	
	// string.properties ���Ͽ� ������ �Ӽ��� �����ͼ� ������ ����
	@Value("${user.name}")
	protected String user_name;
	@Value("${user.email}")
	protected String user_email;
	/*
	 * �������� ���������� bean�� ����ϴ� �ڵ�
	 * @Autowired
	 * private BookDao bookDao
	 * �� �ڵ忡�� �޸� leak(����)������ ����Ǿ�
	 * ������ �ڵ带 �����Ѵ�
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
