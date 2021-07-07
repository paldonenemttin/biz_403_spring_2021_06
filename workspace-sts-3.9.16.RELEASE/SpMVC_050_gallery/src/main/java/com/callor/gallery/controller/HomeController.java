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
	 * �� Ŭ������ @RequestParam�� ���̸� �ȵ�
	 * �� Ŭ������ @RequestParam�� ���̸� 400������ ����.
	 */
	@RequestMapping(value = "/sub", method = RequestMethod.POST)
	public String home(@RequestParam("one_file") MultipartFile one_file, MultipartHttpServletRequest m_file) {

		log.debug("���ϰ��� : {}", m_file.getFile("m_file").getSize());// param�� getfile���� ���ڿ��� ��ġ�ؾ� �Ѵ�

		// �ټ��� ���� ���ε�Ǹ�
		// ���ϵ��� ������ mfile ��ü�� ���� �ȴ�
		// m_file ��ü���� getFiles() method�� �����
		// ���ϵ� list�� �����Ѵ�
		// list<MultipartFile> type�� ��ü�� ��´�
		// �̶� getFiles()���� form���� ������ input tag�� name ���� �������ش�
		// ���� input tag���� multiple="multiple" ������ �Ǿ�� �Ѵ�
		List<MultipartFile> mfiles = m_file.getFiles("m_files");
		for (MultipartFile file : mfiles) {
			log.debug("���ϵ� :{}", file.getName());
		}
		return "home";
	}

}