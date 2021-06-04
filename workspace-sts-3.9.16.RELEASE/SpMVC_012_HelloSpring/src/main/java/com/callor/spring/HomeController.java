package com.callor.spring;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger("HomeController");

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		// logger�� method��
		// �� method���� logger������ level

		// logback-test.xml�� level�� INFO�� ������ �ϸ�
		// �ڵ� ������ logger.trace(), logger.debuh�� ����� ���� ��� �ڵ尡 ���õȴ�
		logger.trace("Ʈ���̽�");
		logger.debug("�����");
		logger.info("���� Welcome home! The client locale is {}.", locale);
		logger.warn("����");
		logger.error("����");
		 
		logger.debug(String.valueOf(300 * 400));
		logger.debug("����� Home Controller return�ٷ� ��");

		return "home";
	}

}
