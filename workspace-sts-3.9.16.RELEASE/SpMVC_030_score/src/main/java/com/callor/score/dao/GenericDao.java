package com.callor.score.dao;

import java.util.List;

/*
 * Generic Interface
 * ���� �Ű�����, return type�� �������� ���� �������̽�
 * ���� ����� method�� ���� �������̽��� �����Ҷ�
 * ���� ����� ���ʰ�
 * ����� method�� ���� �����ϱ� ���� ǥ�� parent�� �������̽��� ����� 
 */
public interface GenericDao<VO, PK> {
	
	public List<VO> selectAll();
	public VO findById(PK pk);
	
	public int insert(VO vo);
	public int update(VO vo);
	public int delete(PK pk);

}
