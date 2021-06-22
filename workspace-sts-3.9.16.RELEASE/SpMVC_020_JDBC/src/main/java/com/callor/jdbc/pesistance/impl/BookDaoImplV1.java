package com.callor.jdbc.pesistance.impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.callor.jdbc.model.BookVO;
import com.callor.jdbc.pesistance.BookDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository("bookDaoV1")
public class BookDaoImplV1 implements BookDao {
	
	// console로 log를  짜ㅣㄱ기 위해 log 객체 생성
	// lombok
	//private static Logger log = LoggerFactory.getLogger("SERVICE");
	
	protected final JdbcTemplate jdbcTemplate;
	
	public BookDaoImplV1(JdbcTemplate jdbcTemplate) {
		// TODO Auto-generated constructor stub
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public List<BookVO> selectAll() {
		// TODO Auto-generated method stub
		String sql = " SELECT ";
		sql += "bk_isbn,";
		sql += "bk_title,";
		sql += "C.cp_code as bk_ccode,";
		sql += "A.au_code as bk_acode,";
		sql += "bk_date,";
		sql += "bk_price,";
		sql += "bk_pages ";
		sql	+= "FROM tbl_books B ";
		sql += " LEFT JOIN tbl_author A";
		sql += " 	ON B.bk_acode = a.au_code";
		sql += " LEFT JOIN tbl_company C";
		sql += " 	ON B.bk_ccode = C.cp_code";
		List<BookVO> books = jdbcTemplate.query(sql, new BeanPropertyRowMapper<BookVO>(BookVO.class));
		/*
		 * jdbsTemplet.query(sql,return type)
		 * sql문을 실행한 후 return type 형태로 데이터를 변환하여
		 * return 해달라
		 */
		log.debug("SELECT {}", books.toString());
		return books;
	}

	@Override
	public BookVO findById(String pk) {
		return null;
		// TODO Auto-generated method stub

	}

	@Override
	public int insert(BookVO vo) {
		// TODO Auto-generated method stub
		String sql = " INSERT INTO tbl_books( ";
		sql += "bk_isbn,";
		sql += "bk_title,";
		sql += "bk_ccode,";
		sql += "bk_acode,";
		sql += "bk_date,";
		sql += "bk_price,";
		sql += "bk_pages)";
		sql += "VALUES(?,?,?,?,?,?,?)";
		
		Object[] params = new Object[] {
				vo.getBk_isbn(),
				vo.getBk_title(),
				vo.getBk_ccode(),
				vo.getBk_acode(),
				vo.getBk_date(),
				vo.getBk_pages(),
				vo.getBk_price()
		};
		return jdbcTemplate.update(sql, params);
	}

	@Override
	public int update(BookVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String pk) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<BookVO> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BookVO> findByDate(String date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BookVO> findByComp(String comp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BookVO> findByAuthor(String author) {
		// TODO Auto-generated method stub
		return null;
	}

}
