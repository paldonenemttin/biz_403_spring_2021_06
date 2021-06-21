package com.callor.jdbc.pesistance.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.callor.jdbc.model.AuthorVO;
import com.callor.jdbc.model.CompVO;
import com.callor.jdbc.pesistance.AuthorDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository("authorDaoV1")
public class AuthorDaoImplV1 implements AuthorDao{
	
	/*
	 * 일반적인 spring Framework에서 다른 bean을 연결하기
	 * @Autowired는 이미 bean으로 생성되어 Spring 
	 */
//	protected final JdbcTemplate jdbcTemplate;
	@Autowired
	protected JdbcTemplate jdbcTemplate;
	
	public AuthorDaoImplV1(JdbcTemplate jdbcTemplate) {
		// TODO Auto-generated constructor stub
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<AuthorVO> selectAll() {
		// TODO Auto-generated method stub
		String sql = " SELECT * FROM tbl_author ";
		List<AuthorVO> authorList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<AuthorVO>(AuthorVO.class));
		log.debug("SELECT {}",authorList.toString());
		return authorList;
	}

	@Override
	public AuthorVO findById(String au_code) {
		
		String sql = " SELECT * FROM tbl_author ";
		Object[] params = new Object[] {au_code};
		AuthorVO vo = (AuthorVO)jdbcTemplate.query(sql, params,  new BeanPropertyRowMapper<AuthorVO>(AuthorVO.class));
		log.debug("SELECT {}",vo.toString());
		return vo;
		// TODO Auto-generated method stub
		
	}

	@Override
	public int insert(AuthorVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(AuthorVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String pk) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<AuthorVO> findByAName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AuthorVO> findByATel(String tel) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
