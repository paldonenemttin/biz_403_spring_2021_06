package com.callor.book.controller.notuse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@Controller
//@RequestMapping("/news")
public class NaverNewsController {
	
	@RequestMapping(value={"/",""} , method=RequestMethod.GET)
	public String home(Model model) {
//		model.addAttribute("pHolder", "���� �˻���");
		model.addAttribute("CAT", "NEWS");
		return "/home";
	}
	

}
