package com.callor.jdbc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.callor.jdbc.model.UserVO;

public class Main {
	
	/*
	 * primitive type�� ������ �Լ��� �谳������ �����Ͽ�����
	 * �Լ����� �Ű������� ���� �����Ͽ���
	 * ȣ���ϱ� �� ���� ������ ���� ������ ����
	 * 
	 * type�� ����(class type�� ����, Class �� ������ ��ü����)��
	 * �Լ��� �Ű������� �����Ͽ�����
	 * ������ ����� �Ϻθ� �����ϰų� �߰� �����ϸ�
	 * ���� �Լ���
	 */
	public static void main(String[] args) {
		
		int num1 = 0;
		add(num1);
		System.out.println(num1);
		
		List<UserVO> userList = new ArrayList<UserVO>();
		add(userList);
		add(userList);
		add(userList);
		System.out.println("add�� :" + userList.toString());
	}
	
	public static void add(int num) {
		num = 1000;
	}
	
	public static void add(List<UserVO> users) {
		
		Random rnd = new Random();
		UserVO userVO = new UserVO();
		userVO.setName("dlalswn");
		userVO.setUsername(String.valueOf(rnd.nextInt(100)));
	}

}
