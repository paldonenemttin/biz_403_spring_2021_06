package com.callor.oneday.pesistance;

import java.util.List;

public interface GenericDao<VO, PK> {
	
	public List<VO> selectAll();
	public void findById(PK pk);
	public int insert(VO vo);
	public int update(VO vo);
	public int delete(PK pk);
}
