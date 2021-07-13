package com.callor.gallery.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.gallery.model.GalleryDTO;
import com.callor.gallery.model.GalleryFilesDTO;
import com.callor.gallery.model.MemberVO;
import com.callor.gallery.service.GalleryService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Controller
@Slf4j
@RequestMapping(value = "/gallery")
public class GalleryController {

	@Qualifier("galleryServiceV2")
	protected final GalleryService gaService;

	/*
	 * localhost:8080/rootPath/gallery/dumy�� ��û�Ҷ� Request�� ó��
	 * 		http://localhost:8080/gallery/dumy
	 * 
	 * a tagŬ����
	 * <a href="${rootPath}/gallery/dumy">����</a>
	 * 
	 * js
	 * location.href = "${rootPath}/gallery/dumy"
	 */
	@RequestMapping(value="/dumy", method = RequestMethod.GET)
	public String dumy() {
		
		return "home";
	}
	
	/*
	 * <form action="${rootPath}/dumy" method="POST">
	 * <input name="str">
	 * <button type="submit">����</button>
	 * js
	 */
	@RequestMapping(value="/dumy", method = RequestMethod.POST)
	public String dumy(String str) {
		
		return "home";
	}
	
	// localhost:8080/rootPath/gallery/ �Ǵ�
	// localhost:8080/rootPath/gallery�� ��û������
	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public String list(Model model) throws Exception {
		List<GalleryDTO> gaList = gaService.selectAll();
		model.addAttribute("GALLERYS", gaList);
		model.addAttribute("BODY", "GA-LIST");
		return "home";
	}

	@RequestMapping(value = "/input", method = RequestMethod.GET)
	public String input(Model model, HttpSession session) {

		MemberVO mVO = (MemberVO) session.getAttribute("MEMBER");
		if(mVO == null) {
			return "redirect:/member/login";
		}
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat st = new SimpleDateFormat("hh:MM:ss");

		String curDate = sd.format(date);
		String curTime = st.format(date);

		GalleryDTO gaDTO = GalleryDTO.builder().g_date(curDate).g_time(curTime).g_writer("aipro0124").build();

		model.addAttribute("CMD", gaDTO);
		model.addAttribute("BODY", "GA-INPUT");
		return "home";
	}

	@RequestMapping(value = "/input", method = RequestMethod.POST)
	public String input(GalleryDTO gaDTO, MultipartFile one_file, MultipartHttpServletRequest m_file, Model model)
			throws Exception {
		log.debug("������ ���� : {}", gaDTO.toString());
		log.debug("�̱����� :{}", one_file.getOriginalFilename());
		log.debug("��Ƽ���� :{}", m_file.getFileMap().toString());

		gaService.input(gaDTO, one_file, m_file);
		return "redirect:/gallery";
	}

	@RequestMapping(value = "/detail/{seq}", method = RequestMethod.GET)
	public String detail(@PathVariable("seq") String seq, Model model) {

		Long g_seq = 0L;

		try {
			g_seq = Long.valueOf(seq);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			return "redirect:/gallery";
		}

		List<GalleryFilesDTO> gfList = gaService.findByIdGalleryFiles(g_seq);
		model.addAttribute("GFLIST", gfList);
		model.addAttribute("BODY", "GA-DETAIL");
		return "home";
	}
	
	@RequestMapping(value="detail2/{seq}" , method = RequestMethod.GET)
	public String detail(
			@PathVariable("seq")
			String seq , Model model, HttpSession session) {
		
		Long g_seq = 0L;
		try {
			g_seq = Long.valueOf(seq);
		} catch (Exception e) {
			// TODO: handle exception
			log.debug("������ id�� ����");
			return "redirect:/";
		}
		GalleryDTO galleryDTO = gaService.findByIdGallery(g_seq);
		model.addAttribute("GALLERY", galleryDTO);
		model.addAttribute("BODY", "GA-DETAIL-V2");
		return "home";
	}
	
	/*
	 * ÷�������� �ִ� ������ ����
	 */
	@RequestMapping(value="/delete" , method = RequestMethod.GET)
	public String delete(@RequestParam("seq") String seq, HttpSession session) {
		
		// ������ �䱸�ϸ� ���� �α����� �Ǿ����� Ȯ��
//		MemberVO memVO = (MemberVO) session.getAttribute("MEMBER");
//		if(memVO == null) {
//			return "redirect:/member/login";
//		}
		
		Long g_seq = 0L;
		try {
			g_seq = Long.valueOf(seq);
		} catch (Exception e) {
			// TODO: handle exception
			log.debug("����");
			return "redirect:/gallery";
		}
		
		gaService.delete(g_seq);
		
		return "redirect:/gallery";
	}
	@ResponseBody
	@RequestMapping(value="/file/delete/{seq}", method = RequestMethod.GET)
	public String file_delete(@PathVariable("seq") String seq) {
		
		return "OK";
	}
	

}
