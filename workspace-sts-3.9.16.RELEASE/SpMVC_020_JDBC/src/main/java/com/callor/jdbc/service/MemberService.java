package com.callor.jdbc.service;

import com.callor.jdbc.model.UserVO;

public interface MemberService {
	
	public int join(UserVO userVO);
	// login ����� username(id) password�� �Ű������� �޾Ƽ�
	// ȸ�������� �˻��� �� ��ȿ�� ȸ���̸� ȸ��������� return�ϰ�
	// �׷��� ������ null�� return�ϴ� ������ ����
	public UserVO login(String username, String password);
	
	public UserVO viewInfo(String username);
	public int updateInfo(UserVO userVO);
	
	public int expire(String username);

}
