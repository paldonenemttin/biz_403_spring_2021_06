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
		sql += " WHERE au_code = ?";
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
		String sql = " SELECT * FROM tbl_author ";
		sql += " WHERE au_name LIKE CONCAT('%', ? , '%') ";
		
		List<AuthorVO> authorList 
		=  jdbcTemplate.query(sql, new Object[] {name},
				new BeanPropertyRowMapper<AuthorVO>(AuthorVO.class));
		return authorList;
	}

	@Override
	public List<AuthorVO> findByATel(String tel) {
		// TODO Auto-generated method stub
		String sql = " SELECT * FROM tbl_author ";
		sql += " WHERE au_tel LIKE CONCAT('%',  ?, '%') ";
		
		/*
		 * 전화번호로 조회를 하면 1개의 데이터만 추출될 것이다
		 * 하지만 DB조회에서 PK를 기준으로 조회하는 경우를 제외하고는
		 * 모두 List type으로 데이터가 추출된다고 생각해야 한다.
		 */
		List<AuthorVO> authorList 
		=  jdbcTemplate.query(sql, new Object[] {tel},
				new BeanPropertyRowMapper<AuthorVO>(AuthorVO.class));
		return authorList;

	}
	

}
