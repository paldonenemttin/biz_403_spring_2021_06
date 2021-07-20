package com.team.statea.dao.ext;

import java.util.Map;

import com.team.statea.dao.GenericDao;
import com.team.statea.model.UserVO;

public interface UserDao extends GenericDao<UserVO, String> {

	public int join(UserVO usVO);

	public UserVO login(UserVO usVO);

	public int insertOrUpdate(UserVO usVO);
	
	public int update(UserVO userVO);

	
	
	
	
	

}