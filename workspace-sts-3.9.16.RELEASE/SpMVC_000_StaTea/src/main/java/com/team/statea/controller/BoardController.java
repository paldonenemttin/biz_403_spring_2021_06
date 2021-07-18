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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.team.statea.dao.ext.BoardDao;
import com.team.statea.dao.ext.ImageDao;
import com.team.statea.model.BoardVO;

import com.team.statea.model.dto.BoardListDTO;
import com.team.statea.model.dto.BoardViewDTO;
import com.team.statea.service.BoardService;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Controller
@RequestMapping("/board")
public class BoardController {
	
	protected final BoardService bdService;
	protected final BoardDao bdDao;
	protected final ImageDao mDao;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(HttpSession httpSession, Model model) {
		List<BoardListDTO> liList = bdService.selectList();
		model.addAttribute("BOARDS", liList);
		return "board/list";
	}

	@RequestMapping(value = "/input", method = RequestMethod.GET)
	public String insert(Model model) {
		BoardVO boardVO = new BoardVO();
		
		String bdCode = bdDao.getMaxCode();
		String bdNum = bdCode.substring(1);
		
		Integer bdSeq = Integer.valueOf(bdNum) + 1;
		
		String newBdCode = String.format("%s%04d", "B", bdSeq);
		
		Date date = new Date(System.currentTimeMillis()); 
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");
		
		String datetime = sd.format(date);
		
		boardVO = BoardVO.builder().bd_time(datetime).bd_code(newBdCode).build();
		model.addAttribute("FREE", boardVO);
		
		return "board/input";
		
	}
	
	@RequestMapping(value = "/input", method = RequestMethod.POST)
	public String insert( BoardVO boardVO, MultipartHttpServletRequest m_file) throws Exception {
		
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
		bdService.viewCount(bd_code);
		model.addAttribute("BVIEWS",boardviewDTO);
		return "board/view";
		
	}
	
	@RequestMapping(value="/delete", method = RequestMethod.GET)
	public String delete(@RequestParam("bd_code") String bd_code , HttpSession session) {
		
		bdService.delete(bd_code);
		return "redirect:/board/list";
	}
	
	@RequestMapping(value="/update/{code}", method = RequestMethod.GET)
	public String update(@PathVariable("code") String code, Model model, HttpSession session){ 
			
			String bd_code = null;
			try {
				bd_code = String.valueOf(code);
			} catch (Exception e) {
				// TODO: handle exception
				return "redirect:/";
			}
			
			BoardViewDTO boardviewDTO = bdService.selectView(bd_code);
			model.addAttribute("FREE",boardviewDTO);
		return "board/input";
	}
	
	@RequestMapping(value="/update/{code}", method = RequestMethod.POST)
	public String update(@PathVariable("code") String code,Long img_code,BoardVO boardVO, MultipartHttpServletRequest m_file) throws Exception {
		
		
		bdService.update(code, boardVO, m_file);
		return "redirect:/board/view/{code}";
	}
	
	@ResponseBody
	@RequestMapping(value = "/file/delete/{code}", method = RequestMethod.GET)
	public String filedelete(@PathVariable("code") String code) {

		Long img_code = 0L;

		try {
			img_code = Long.valueOf(code);
		} catch (Exception e) {
			// TODO: handle exception
			return "FAIL_CODE";
		}

		int ret = bdService.fileDelete(img_code);
		if (ret > 0) {
			return "DROP";
		} else {
			return "FAIL";
		}
	}
}
