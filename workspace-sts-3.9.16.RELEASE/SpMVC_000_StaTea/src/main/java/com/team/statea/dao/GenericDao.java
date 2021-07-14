package com.team.statea.dao;

import java.util.List;

public interface GenericDao<VO, PK> {
	
	public List<VO> selectAll();
	public VO findById(PK pk);
	public int insert(VO vo);
	public int update(PK pk);
	public int delete(PK pk);

}
