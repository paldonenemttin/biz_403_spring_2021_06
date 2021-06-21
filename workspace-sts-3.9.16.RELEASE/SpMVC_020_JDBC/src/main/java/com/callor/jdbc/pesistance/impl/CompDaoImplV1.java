package com.callor.jdbc.pesistance.impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.callor.jdbc.model.CompVO;
import com.callor.jdbc.pesistance.CompDao;

import lombok.extern.slf4j.Slf4j;


/*
 * @Component 
 * ��� Component�� ��ǥ�ϴ� Annotation
 * ������ �������� �ټ� ����� ���� �ҿ�Ȥ���
 * 
 * @Controller, @Service, @REpository �̷��� Annotation�� ����Ѵ�
 * Spring Container���� �� ǥ���� ������ Ŭ������ bean���� �����Ͽ�
 * ������ �޶�� ���þ�
 * 
 * CompV) c = new CompVO();// �̰� ���°� ����
 * Object o = new CompVO();// �� ��õ
 * 
 * CompServiceImplV2 cs = new CompServiceImplV1();
 * CompService cs = new CompServiceImplV1();
 */
@Slf4j
@Repository("compDaoV1")
public class CompDaoImplV1 implements CompDao{

	protected final JdbcTemplate jdbcTemplate;
	
	public CompDaoImplV1(JdbcTemplate jdbcTemplate) {
		// TODO Auto-generated constructor stub
		this.jdbcTemplate = jdbcTemplate;
	}
	@Override
	public List<CompVO> selectAll() {
		// TODO Auto-generated method stub
		String sql = " SELECT * FROM tbl_company ";
		List<CompVO> comp = jdbcTemplate.query(sql, new BeanPropertyRowMapper<CompVO>(CompVO.class));
		log.debug("SELECT {}",comp.toString());
		return comp;
	}

	@Override
	public CompVO findById(String cp_code) {
		// TODO Auto-generated method stub
		String sql = " SELECT * FROM tbl_company ";
		Object[] params = new Object[] {cp_code};
		CompVO vo = (CompVO)jdbcTemplate.query(sql, params,  new BeanPropertyRowMapper<CompVO>(CompVO.class));
		log.debug("SELECT {}",vo.toString());
		return vo;
		
		
	}

	@Override
	public int insert(CompVO vo) {
		// TODO Auto-generated method stub
		String sql = " INSERT INTO tbl_company ";
		sql += " (cp_code,cp_title,cp_ceo,cp_tel,cp_addr)";
		sql += " VALUES(?,?,?,?,?)";
		
		Object[] params = new Object[] {
			vo.getCp_code(),
			vo.getCp_title(),
			vo.getCp_ceo(),
			vo.getCp_tel(),
			vo.getCp_addr()
		};
		return jdbcTemplate.update(sql,params);
	}

	@Override
	public int update(CompVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * jdbcTemplate�� ����� Query�� �����Ҷ�
	 * �� method���� ���������� �޾�
	 * Query�� �������ٵ�
	 * �̶� �Ű����̴� primitive�� ������ ���� ��ȯ��Ű�� ������� �ִ�
	 * ����������� �Ű������� wrapper class type ���� ����
	 * �� �������� ��� int long ��� integer Long������ ����
	 * 
	 * vo�� ��ܼ� ���޵� ���� objextp[ �迭�� ��ȯ �� jdbcTemplate�� ��������� �Ѵ�
	 * 
	 * ������, 1 ~ 2��  ������ ���� �����Ҷ� object[]
	 */
	@Override
	public int delete(String cpcode) {
		// TODO ���ǻ� ����
		
		String sql = " DELETE FROM tbl_company ";
		sql += " WHERE cp_code = ? ";
		
		Object[] params = new Object[] { cpcode };
		jdbcTemplate.update(sql, cpcode);
		
		return 0;
	}
	
	/*
	 * tbl_company table���� cpcode(���ǻ��ڵ�)�� ���� ū ���� �����ϱ�
	 */
	@Override
	public String findByMaxCode() {
		// TODO Auto-generated method stub
		String sql = " select max(cp_code) from tbl_company ";
		
		String cpCode = (String) jdbcTemplate.queryForObject(sql, String.class);
		return cpCode;
	}
	@Override
	public List<CompVO> finByCName(String cname) {
		// TODO Auto-generated method stub
		String sql = " SELECT * FROM tbl_company ";
		sql += " WHERE cp_name LIKE CONCAT('%' , ? '%' )";
		List<CompVO> compList = jdbcTemplate.query(sql, new Object[] {cname},
				new BeanPropertyRowMapper<CompVO>(CompVO.class));
		return null;
	}
	@Override
	public List<CompVO> finByTel(String tel) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<CompVO> finByCeo(String ceo) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public CompVO findByCCode(String code) {
		// TODO Auto-generated method stub
		return null;
	}

}