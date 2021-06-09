package com.callor.jdbc.service.impl;

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
			// �������λ� C�� �ڸ��� ����
			String _code = cpCode.substring(1);
			Integer intCode = Integer.valueOf(_code) +1;
			
			cpCode = String.format("C%04d", intCode);
		}
		vo.setCp_code(cpCode);
		compDao.insert(vo);
		return 0;
	}
	

}
