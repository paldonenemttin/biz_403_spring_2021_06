package com.callor.gallery.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.callor.gallery.model.MemberVO;
import com.callor.gallery.persistance.ext.MemberDao;
import com.callor.gallery.service.MemberService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service("memberServiceV1")
public class MemberServiceImplV1 implements MemberService{

	protected final MemberDao mDao;
	
	@Autowired
	public int create_member_table(MemberDao dumy) {
		Map<String, String> maps = new HashMap<String, String>();
		return mDao.create_table(maps);
	}
	
	/*
	 * 1. ȸ�����Կ��� ���ʷ� ���Ե� ����� �����̴�
	 * 		ȸ�����̺� �����Ͱ� �ִ°� ���°�
	 * 			selectAll method�� ����� ���� ���Ե� member�ΰ��� Ȯ��
	 * 2. ���� ������ ���� ������ �����ڴ� level�� 0
	 * 3. ������ �ƴ� �Ϲ� �����ڴ� �⺻ ������ 9
	 * 4. level�� 6���� ū ����� �̹��� ���⸸ ����
	 * 5. �̹��� ����� �Ϸ��� ������ 6���� �۾ƾ� �Ѵ�
	 * 6. ���� ������ ����� ���� ������ �Ǹ� ������ 6���� �����Ѵ�
	 * 7. �̹� ���Ե� ����� m_userid ������ ������ ���ؼ� ���޵Ǹ� ȸ�� ������ update�Ѵ�
	 */
	@Override
	public MemberVO join(MemberVO memberVO) {
		// TODO Auto-generated method stub
		List<MemberVO> members = mDao.selectAll();
		log.debug("Members[]",members);
		// ���� member data�� ���� ����
		// ���ʷ� ���� ��û�� �� ����
		// ���ʷ� ���ԵǴ� member�� admin�̴�
		// ������ level�� 0�̴�
		if(members == null || members.size() < 1) {
			memberVO.setM_level(0);
		} else {
			memberVO.setM_level(9);
		}
		mDao.insertOrUpdate(memberVO);
		return memberVO;
	}

	@Override
	public MemberVO update(MemberVO memberVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberVO findById(String m_userid) {
		// TODO Auto-generated method stub
		MemberVO memberVO = mDao.findById(m_userid);
		if(memberVO == null) {
			log.debug("�������� ���� id {}",m_userid);
		}else {
			log.debug("��ȸ�� ����� ���� {}", memberVO.toString());
		}
		return memberVO;
	}

	@Override
	public MemberVO login(MemberVO memberVO, Model model) {
		// TODO Auto-generated method stub
		
		/*
		 * 1. memberVO���� m_userid�� getter�� ��
		 * 2. findById()�� ���� id ��ȸ
		 * 3. ���� ����� Null�̸� ���Ե��� ������
		 * 4. ����� null�� �ƴϸ�
		 * 5. ��й�ȣ ��ġ��ȸ
		 * 6. ��ġ ���� ������ �α��� �ź�
		 * 7. ��ġ�ϸ� �α��� ó��
		 */
		
		MemberVO findVO = mDao.findById(memberVO.getM_userid());
		
		if(findVO == null) {
			model.addAttribute("LOGIN_FAIL", "NOT_USERID");
			return null;
		}
		if(findVO.getM_password().equals(memberVO.getM_password())) {
			return findVO;
		}
		
		model.addAttribute("LOGIN_FAIL", "NEQ_PASS");
		return null;
	}

}
