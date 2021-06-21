package com.callor.jdbc.pesistance;

import java.util.List;

import com.callor.jdbc.model.CompVO;

public interface CompDao extends GenericDao<CompVO,String>{
	
	public String findByMaxCode();
	public List<CompVO> finByCName(String name);
	public List<CompVO> finByTel(String tel);
	public List<CompVO> finByCeo(String ceo);
	public CompVO findByCCode(String code);
	
	

}
