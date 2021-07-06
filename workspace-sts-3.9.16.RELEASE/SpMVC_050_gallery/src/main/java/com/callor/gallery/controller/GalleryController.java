package com.callor.gallery.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.gallery.model.GalleryDTO;
import com.callor.gallery.service.GalleryService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Controller
@Slf4j
@RequestMapping(value="/gallery")
public class GalleryController {
	
	protected final GalleryService gaService;
	
	@RequestMapping(value={"/", ""} , method = RequestMethod.GET)
	public String list(Model model) throws Exception  {
		List<GalleryDTO> gaList = gaService.selectAll();
		model.addAttribute("GALLERYS",gaList);
		model.addAttribute("BODY","GA-LIST");
		return "home";
	}
	
	@RequestMapping(value="/input", method = RequestMethod.GET)
	public String input(Model model) {
		
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-mm-dd");
		SimpleDateFormat st = new SimpleDateFormat("hh:mm:ss");
		
		String curDate = sd.format(date);
		String curTime = st.format(date);
		
		GalleryDTO gaDTO = GalleryDTO.builder().g_date(curDate).g_time(curTime).g_writer("aipro0124").build();
		
		model.addAttribute("CMD", gaDTO);
		model.addAttribute("BODY","GA-INPUT");
		return "home";
	}
	
	@RequestMapping(value="/input", method = RequestMethod.POST)
	public String input(GalleryDTO gaDTO,MultipartFile one_file,
			MultipartHttpServletRequest m_file, Model model) throws Exception {
		log.debug("������ ���� : {}", gaDTO.toString());
		log.debug("�̱����� :{}", one_file.getOriginalFilename());
		log.debug("��Ƽ���� :{}", m_file.getFileMap().toString());
		
		gaService.input(gaDTO, one_file, m_file);
		return "redirect:/gallery";
	}

}
