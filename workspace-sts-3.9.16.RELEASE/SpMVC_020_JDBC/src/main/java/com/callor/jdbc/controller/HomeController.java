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
	
	/*
	 * ����ڿ��� Response�� �Ҷ�
	 * forward����� redirect����� �ִ�
	 * 
	 *  forwarding��
	 *  service ���� ������(��ȸ��) �����͸�
	 *  *.jsp ���ϰ� rendering�Ͽ� ����ڿ��� HTML�ڵ�� �����Ѵ�
	 *  
	 *  service���� 
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
		 * �Ű������� ���޹��� model class type������ Model��
		 * �Ӽ��� �ϳ� �߰��Ѵ�.
		 * �Ӽ��� �̸��� user�̸� ���� user_name�� ��� ���̴�
		 * 
		 * Model��ü�� ��� �Ӽ�(����)����  Rendering�� �Ϸ�Ǹ� �޸𸮿��� �����ȴ�
		 */
		
		model.addAttribute("user",user_name);
		rentService.viewBookAndComp();
		return "home";
	}
	
}
