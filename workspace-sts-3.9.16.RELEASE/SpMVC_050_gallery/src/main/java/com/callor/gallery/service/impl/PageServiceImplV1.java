package com.callor.gallery.service.impl;

import org.springframework.stereotype.Service;

import com.callor.gallery.model.PageDTO;
import com.callor.gallery.service.PageService;

import lombok.Setter;

@Setter
@Service
public class PageServiceImplV1 implements PageService{

	// �� �������� ������ ������ ����Ʈ�� ����
	protected int listPerPage = 10;
	// �� �������� ������ ������ nav�� ����
	protected int navsPerPage = 5;
	
	/*
	 * ��ü������ ���� ���� ������ ��ȣ��
	 *  �Ű������� �޾Ƽ� pagination�� �׸��µ� 
	 *  �ʿ��� �����͸� �����ϱ�
	 */
	@Override
	public PageDTO makePageation(int totalListSize, int currentPage) {
		// TODO Auto-generated method stub
		if(totalListSize < 1) return null;
		
		// �� ������ �����ϸ� ��ü ������Ʈ�� ǥ���ϴµ� �� �������� �ʿ��Ѱ��� ���
		// �� ������ int�� �����ͷ� ������ �����ϹǷ� �Ҽ��� ���ϸ� ������ �ڸ���
		// ������ ������ ������ listPerPgae ���� ������ ������ �������� �����ϴ� totalPage ���� ���ȴ�
		
		// �Ǽ��� ���� �Ҽ��� ���Ͽ��� �ݿø��Ͽ� ����� ����� �Լ�
		// Math.round() �ݿø�
		// Math.floor()  �Ҽ������� ����
		// Math.ceil() �Ҽ��� ���� ������ �ø�
		
		int totalPages = (int)Math.round((double)totalListSize / (double)this.listPerPage);
		
		int startPage = currentPage - (this.navsPerPage/2);
		
		// ���� ������������ ����ؼ� 1���� ������ ������ 1���� ����
		startPage = startPage < 1 ? 1 : startPage;
		
		int endPage = startPage = this.navsPerPage;
		// ������ �������� ��ü ������ ������ Ŀ�ø� ������ �������� �����ϱ�
		endPage = endPage > totalPages ? totalPages : endPage;
		
		/*
		 * �����͸� �ڸ��� ���� ���� ����
		 * �� �� ������ ���� ����° ��ü�� �ڸ��� ����
		 * ��ü �����Ͱ� *** ����� �����ϸ� ������ �������� ǥ���ϱ� ���� offet limit��
		 * offset : 600
		 * limit : 5�� �Ǿ� �ϴµ� �Ʒ� ���꿡�� limit 690�� �Ǿ� ������
		 * �����͸� �ڸ��� �������� Exception�� �߻� �� ���̴�
		 */
		int offset = (currentPage - 1) * this.listPerPage;
		int limit =  offset + this.listPerPage;
		
		// ������ ��ġ ���� ��ü ����Ʈ���� ũ�� ��ü ����Ʈ �� ������ �����ϱ�
		limit = limit > totalListSize ? totalListSize : limit;
		
		PageDTO pageDTO = PageDTO.builder().totalPages(totalPages).startPage(startPage).endPage(endPage).offset(offset).build();
		return pageDTO;
	}

}
