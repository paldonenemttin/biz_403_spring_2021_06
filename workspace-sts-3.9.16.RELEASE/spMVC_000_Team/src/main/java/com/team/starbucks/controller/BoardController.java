package com.team.starbucks.controller;

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

import com.team.starbucks.dao.ext.BoardDao;
import com.team.starbucks.dao.ext.ImageDao;
import com.team.starbucks.model.BoardListDTO;
import com.team.starbucks.model.BoardVO;
import com.team.starbucks.model.BoardViewDTO;
import com.team.starbucks.model.UserVO;
import com.team.starbucks.service.BoardService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller
public class BoardController {
	
	protected final BoardService bdService;
	protected final BoardDao bdDao;
	protected final ImageDao mDao;
	
	@RequestMapping(value = "/board", method = RequestMethod.GET)
	public String list(HttpSession httpSession, Model model) {
		List<BoardListDTO> liList = bdService.selectList();
		bdService.searchList();
		model.addAttribute("BOARDS", liList);
		model.addAttribute("BB", "BOARD-LIST");
		return "board/list";
	}

	@RequestMapping(value = "board/input", method = RequestMethod.GET)
	public String insert(Model model, HttpSession session) {
		
		UserVO userVO = (UserVO) session.getAttribute("LOGIN");
		
		log.debug(userVO.toString());
		
		
		BoardVO boardVO = new BoardVO();
		
		String bdCode = bdDao.getMaxCode();
		String bdNum = bdCode.substring(1);
		
		Integer bdSeq = Integer.valueOf(bdNum) + 1;
		
		String newBdCode = String.format("%s%04d", "B", bdSeq);
		
		Date date = new Date(System.currentTimeMillis()); 
		SimpleDateFormat dd = new SimpleDateFormat("yyyy-MM-dd hh:MM:ss");
		
		String dt = dd.format(date);
		
		boardVO = BoardVO.builder().bd_time(dt).bd_code(newBdCode).build();
		model.addAttribute("FREE", boardVO);
		model.addAttribute("BB", "BOARD-INPUT");
		return "board/input";
		
	}
	
	@RequestMapping(value = "board/input", method = RequestMethod.POST)
	public String insert( BoardVO boardVO, MultipartHttpServletRequest m_file) throws Exception {
		
		bdService.insert(boardVO, m_file);
		return "redirect:/board";
		
	}
	
	@RequestMapping(value = "board/view/{code}", method = RequestMethod.GET)
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
		model.addAttribute("BB", "BOARD-VIEW");
		return "board/view";
		
	}
	
	@RequestMapping(value="board/delete", method = RequestMethod.GET)
	public String delete(@RequestParam("bd_code") String bd_code , HttpSession session) {
		
		bdService.delete(bd_code);
		return "redirect:/board";
	}
	
	@RequestMapping(value="board/update/{code}", method = RequestMethod.GET)
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
	
	@RequestMapping(value="board/update/{code}", method = RequestMethod.POST)
	public String update(@PathVariable("code") String code,Long img_code,BoardVO boardVO, MultipartHttpServletRequest m_file) throws Exception {
		
		
		bdService.update(code, boardVO, m_file);
		return "redirect:/board/view/{code}";
	}
	
	@ResponseBody
	@RequestMapping(value = "board/file/delete/{code}", method = RequestMethod.GET)
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