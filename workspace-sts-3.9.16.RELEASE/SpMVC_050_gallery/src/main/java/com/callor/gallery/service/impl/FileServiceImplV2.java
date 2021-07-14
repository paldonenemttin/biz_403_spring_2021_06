package com.callor.gallery.service.impl;

import java.io.File;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service("fileServiceV2")
public class FileServiceImplV2 extends FileServiceImplV1 {

	protected final String winPath;
	protected final String macPath;

	protected String fileUpPath;

	@Autowired
	public void getFilePath(String winPath, String macPath) {

		/*
		 * 
		 * ������ ���ε� �Ҷ� ����� path��������
		 * 
		 * 1. ������ ������ ������ ����� ������ ����
		 * 2. mac ����� ������ ������ �ش� ������ ����
		 * 
		 */
		this.fileUpPath = this.winPath;

	}

	@Override
	public String fileUp(MultipartFile file) throws Exception {

		String originFileName = file.getOriginalFilename();
		if (originFileName == null || originFileName.isEmpty()) {
			return "";
		}

		// ���� �ý��ۿ� macPath�� 
		//		������ ������ �ִ��� Ȯ���ϰ�
		//		������ ���ε� ������ macPath�� ������ ������
		//		�����ϱ�
		File path = new File(macPath);
		if (path.exists()) {
			this.fileUpPath = this.macPath;
		}

		// �ٽ��ѹ� fileUpPath �� �ִ��� �˻�
		// winPath�� ���� ������ ������
		path = new File(fileUpPath);
		if (!path.exists()) {
			path.mkdirs();
		}

		String strUUID = UUID.randomUUID().toString();
		strUUID += originFileName;

		File uploadPathAndFile = new File(fileUpPath, strUUID);
		file.transferTo(uploadPathAndFile);
		return strUUID;

	}

	// ���޹��� �����̸����� �� ������
	// fileUpPath���� ���� ����
	@Override
	public int delete(String imgFileName) {

		/*
		 * fileService.delete(���ϸ�)�� ȣ���Ҷ�
		 * ���ϸ��� null�̰ų� ������ ������ ���ߴ� �ڵ�
		 * 
		 * �̷��� �ڵ�� ȣ���ϴ� ������
		 * 
		 * if(���ϸ� == null || ���ϸ�.isEmpty()) {
		 * 		fileService.delete(���ϸ�)
		 * }
		 * 
		 * ó�� ȣ���Ҽ� ������
		 * delete() method ����ϴ� ���� ������ �̶��
		 * �׶����� �˻��ϴ� �ڵ带 �����ؾ� �Ѵ�
		 * 
		 * �װͺ��ٴ� delete() method�� ���۵ɶ�
		 * ������ null �� ���� �˻��Ͽ� ������ ����ϴ� �����
		 * �� ���� �ڵ尡 �� ���̴�
		 * 
		 */
		if (imgFileName == null || imgFileName.isEmpty()) {
			return 1;
		}

		// �����ϱ� ���� ���� ���� ��ü ����
		File delFile = new File(this.fileUpPath, imgFileName);

		if (delFile.exists()) {

			boolean ok = delFile.delete();
			if (ok) {
				log.debug("���� ���� ����");
				return 1;
			} else {
				log.debug("���� ���� ����");
				/*
				 * method return type�� wrapper class(Integer,Long)������ �����ϸ�
				 * �����ϴ� �޽����� return�Ҷ� null�� return �ϸ�ȴ�
				 * 
				 * primitive ���������� return type�� ������ ���
				 * null ���� return �� �� ����
				 * 
				 * �̷��� ������ �޽����� ���� �������� return �ϰ�
				 * ������ �޽����� ���� �������� return�Ѵ�
				 * 
				 * ȣ���� ������ ����, ���и� �˻��Ҷ�
				 * 
				 * if( ret > 0 ) ����
				 * if( ret < 0 ) ���� �� ���� ����� ����� �� �ִ�
				 * 
				 */
				return -1;
			}
		}
		return 1;
	}
}
