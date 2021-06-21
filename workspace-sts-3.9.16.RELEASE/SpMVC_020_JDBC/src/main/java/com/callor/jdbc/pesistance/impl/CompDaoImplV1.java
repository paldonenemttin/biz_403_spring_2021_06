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
 * 모든 Component를 대표하는 Annotation
 * 컴파일 과정에서 다소 비용이 많이 소요된ㄱ다
 * 
 * @Controller, @Service, @REpository 이러한 Annotation을 사용한다
 * Spring Container에게 이 표식이 부착된 클래스를 bean으로 생성하여
 * 보관해 달라는 지시어
 * 
 * CompV) c = new CompVO();// 이걸 쓰는게 좋다
 * Object o = new CompVO();// 비 츠천
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
	 * jdbcTemplate를 사용해 Query를 실행할때
	 * 각 method에서 개개변수를 받아
	 * Query에 전달할텐데
	 * 이때 매개변ㅜ는 primitive로 받으면 값을 변환시키는 어려움이 있다
	 * 권장사항으로 매개변수는 wrapper class type 으로 설정
	 * 즉 숫자형일 경우 int long 대신 integer Long형으로 선언
	 * 
	 * vo에 담겨서 전달된 값은 objextp[ 배열로 변환 후 jdbcTemplate에 전달해줘야 한다
	 * 
	 * 하지만, 1 ~ 2개  정도의 값을 전달할때 object[]
	 */
	@Override
	public int delete(String cpcode) {
		// TODO 출판사 삭제
		
		String sql = " DELETE FROM tbl_company ";
		sql += " WHERE cp_code = ? ";
		
		Object[] params = new Object[] { cpcode };
		jdbcTemplate.update(sql, cpcode);
		
		return 0;
	}
	
	/*
	 * tbl_company table에서 cpcode(출판사코드)중 가장 큰 값을 추출하기
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