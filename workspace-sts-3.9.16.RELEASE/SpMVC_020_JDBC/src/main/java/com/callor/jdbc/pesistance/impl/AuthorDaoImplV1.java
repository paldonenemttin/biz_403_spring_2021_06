package com.callor.jdbc.pesistance.impl;

import java.util.List;

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
	
	protected final JdbcTemplate jdbcTemplate;
	
	public AuthorDaoImplV1(JdbcTemplate jdbcTemplate) {
		// TODO Auto-generated constructor stub
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<AuthorVO> selectAll() {
		// TODO Auto-generated method stub
		String sql = " SELECT * FROM tbl_author ";
		List<AuthorVO> author = jdbcTemplate.query(sql, new BeanPropertyRowMapper<AuthorVO>(AuthorVO.class));
		log.debug("SELECT {}",author.toString());
		return null;
	}

	@Override
	public void findById(String pk) {
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
