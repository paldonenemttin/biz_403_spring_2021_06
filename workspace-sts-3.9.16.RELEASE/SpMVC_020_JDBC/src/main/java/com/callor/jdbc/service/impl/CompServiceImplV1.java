package com.callor.jdbc.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.callor.jdbc.model.CompVO;
import com.callor.jdbc.pesistance.CompDao;
import com.callor.jdbc.service.CompService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("compServiceV1")
public class CompServiceImplV1 implements CompService{

	protected final CompDao compDao;
	public CompServiceImplV1(CompDao compDao) {
		// TODO Auto-generated constructor stub
		this.compDao = compDao;
	}
	@Override
	public int insert(CompVO vo) {
		// TODO Auto-generated method stub
		String cpCode = compDao.findByMaxCode();
		log.debug("cpcode {}", cpCode);
		if(cpCode == null || cpCode.equals("")) {
			cpCode = String.format("C%04d",1);
		}
		else {
			// 영문접두사 C를 자르고 추출
			String _code = cpCode.substring(1);
			Integer intCode = Integer.valueOf(_code) +1;
			
			cpCode = String.format("C%04d", intCode);
		}
		vo.setCp_code(cpCode);
		compDao.insert(vo);
		return 0;
	}
	@Override
	public List<CompVO> findByCName(String cp_name) {
		// TODO Auto-generated method stub
		
		return compDao.finByCName(cp_name.trim());
	}
	@Override
	public List<CompVO> selectAll() {
		// TODO Auto-generated method stub
		return compDao.selectAll();
	}
	@Override
	public CompVO findByCCode(String cp_code) {
		// TODO Auto-generated method stub
		return compDao.findByCCode(cp_code.trim());
	}
	@Override
	public List<CompVO> findByTitleAndCeoAndTel(String text) {
		// TODO 미래의 나여 반드시 수정하시오..!!
		List<CompVO> mainList = compDao.finByCName(text);
		List<CompVO> ceoList = compDao.finByCeo(text);
		List<CompVO> telList = compDao.finByTel(text);
		
		mainList.addAll(ceoList);
		mainList.addAll(telList);
		
		return mainList;
	}
	
	

}
