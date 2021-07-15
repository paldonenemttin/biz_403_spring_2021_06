package com.callor.gallery.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.gallery.service.FileService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Controller
public class HomeController {

	@Qualifier("fileServiceV2")
	protected final FileService fileService;
	
	
	
	// localhost:8080/rootPath/dumy/gallery/detail요청을 했을때
	// Request를 처리할 method
	// a tag를 클릭했을때
	// <a href="${rootPath}/dumy/gallery/detail">전송</a>
	// 주소창에 직접 입력하고 enter를 눌었을떄
	// http://localhost:8080/rootPath//dumy/gallery/detail
	// locatioin.href =${rootPath}//dumy/gallery/detail로 js에서 실행했을떄
	@RequestMapping(value="/dumy/gallery/detail" , method = RequestMethod.GET)
	public String dumy() {
		
		return "home";
		
	}

	/*
	 * <form action="%{rootPath}/dumy/gallery/detail" method="Post"
	 * <input name="str">
	 * <button type="submit">전송</button>
	 * </form>
	 * 
	 * jsp, html에서 위 코드를 만들고 입력화면을 보여준후
	 * 		input box에 어떤 문자열을 입력한 후 
	 * 		전송 button을 클릭하면
	 * 	이 method가 Request를 수신하고
	 * 		input box에 입력한 문자열은 str 변수에 담기게 된다
	 */
	@RequestMapping(value="/dumy/gallery/detail/image" ,method = RequestMethod.GET)
	public String dumy2(String str) {
		
		return "home";
		
	}
	//localhost:8080/rootPath/gallery
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "redirect:/gallery";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String home(MultipartHttpServletRequest m_file, Model model) throws Exception {

		//		List<MultipartFile> files = m_file.getFiles("m_file");
		//		String fileName = fileService.fileUp(files.get(0));
		//		model.addAttribute(fileName, fileName);

		List<String> fileNames = fileService.filesUp(m_file);
		model.addAttribute("FILES", fileNames);
		return "home";
	}

	/*
	 * MultipartHttpServletRequest
	 * 이 클래스는 @RequestParam을 붙이면 안됨
	 * 이 클래스에 @RequestParam을 붙이면 400오류가 난다.
	 */
	@RequestMapping(value = "/sub", method = RequestMethod.POST)
	public String home(@RequestParam("one_file") MultipartFile one_file, MultipartHttpServletRequest m_file) {

		log.debug("파일갯수 : {}", m_file.getFile("m_file").getSize());// param과 getfile안의 문자열이 일치해야 한다

		// 다수의 파일 업로드되면
		// 파일들의 정보가 mfile 객체에 담기게 된다
		// m_file 객체에서 getFiles() method를 사용해
		// 파일들 list를 추출한다
		// list<MultipartFile> type의 객체에 담는다
		// 이때 getFiles()에는 form에서 설정된 input tag의 name 값을 지정해준다
		// 또한 input tag에는 multiple="multiple" 설정이 되어야 한다
		List<MultipartFile> mfiles = m_file.getFiles("m_files");
		for (MultipartFile file : mfiles) {
			log.debug("파일들 :{}", file.getName());
		}
		return "home";
	}

}
