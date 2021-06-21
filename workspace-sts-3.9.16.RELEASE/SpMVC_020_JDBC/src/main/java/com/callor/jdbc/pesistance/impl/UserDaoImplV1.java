package com.callor.jdbc.pesistance.impl;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.callor.jdbc.model.UserVO;
import com.callor.jdbc.pesistance.UserDao;

public class UserDaoImplV1 implements UserDao{
	
	/*
	 * �����ڿ��� ���Թ޴� ��ü
	 * �����ڿ��� ���Թ޾� �ʱ�ȭ �ϴ� ��ü�� 
	 * @component tjsdjsehls mzffotmaks rksmd
	 */
	protected final JdbcTemplate jdbcTemplate;
	
	public UserDaoImplV1(JdbcTemplate jdbcTemplate) {
		// TODO Auto-generated constructor stub
		this.jdbcTemplate = jdbcTemplate;
	}
	@Override
	public List<UserVO> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserVO findById(String pk) {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public int insert(UserVO vo) {
		// TODO Auto-generated method stub
		String sql = " INSERT INTO tbl_member ( username, password ) ";
		sql += " VALUE(?,?) ";
		
		// jdbcTemplate���� quety�� �����Ҷ�
		// ������ ���� � �ȵɶ��� Object[] �迭�� ������ �ʾƵ� �ȴ�
		return jdbcTemplate.update(sql, vo.getUsername(), vo.getPassword());
	}

	@Override
	public int update(UserVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String pk) {
		// TODO Auto-generated method stub
		return 0;
	}

}
