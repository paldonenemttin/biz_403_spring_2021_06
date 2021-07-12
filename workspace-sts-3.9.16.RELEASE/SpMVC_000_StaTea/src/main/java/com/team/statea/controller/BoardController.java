package com.team.statea.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.team.statea.model.BoardVO;
import com.team.statea.model.ImageVO;
import com.team.statea.model.LikeVO;
import com.team.statea.model.dto.BoardListDTO;
import com.team.statea.model.dto.BoardViewDTO;
import com.team.statea.service.BoardService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/board")
public class BoardController {
	
	protected final BoardService bdService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(HttpSession httpSession, Model model) {
		List<BoardListDTO> liList = bdService.selectList();
		model.addAttribute("BOARDS", liList);
		return "board/list";
	}

	@RequestMapping(value = "/input", method = RequestMethod.GET)
	public String insert(Model model) {
		
		Date date = new Date(System.currentTimeMillis()); 
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd/h:MM:ss");
		
		String datetime = sd.format(date);
		
		BoardVO boardVO = BoardVO.builder().bd_time(datetime).build();
		model.addAttribute("FREE", boardVO);
		
		return "board/input";
		
	}
	
	@RequestMapping(value = "/input", method = RequestMethod.POST)
	public String insert( BoardVO boardVO, MultipartHttpServletRequest m_file, Model model) throws Exception {
		
		bdService.insert(boardVO, m_file);
		
		return "redirect:/board/list";
		
	}
	
	@RequestMapping(value = "/view/{code}", method = RequestMethod.GET)
	public String view(@PathVariable("code") String code, Model model, HttpSession session) {
		String bd_code = null;
		try {
			bd_code = String.valueOf(code);
		} catch (Exception e) {
			// TODO: handle exception
			return "redirect:/";
		}
		
		BoardViewDTO boardviewDTO = bdService.selectView(bd_code);
		model.addAttribute("BVIEWS",boardviewDTO);
		return "board/view";
		
	}
}
