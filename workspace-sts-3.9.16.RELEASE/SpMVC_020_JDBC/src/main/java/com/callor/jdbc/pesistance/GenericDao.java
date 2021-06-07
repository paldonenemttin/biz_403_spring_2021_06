package com.callor.jdbc.pesistance;

import java.util.List;

/*
 * ���׸�(interface�� �θ� ������ �ϴ� super interface
 * Dao�� ���� interface�� �����Ҷ�
 * Table���� Dao�������̽��� �����
 * �������̽��� ��ӹ޾� Ŭ������ �����ϴµ�
 * �̶� ��κ��� Dao���� ���� �̸��� method�� �����ϴ���
 * 
 * �׷��� �� method���� return Ÿ�Կ� �Ű������� �޶�
 * ��¿�� ���� �����(���� ����) method�� ����
 * �������̽��� �ߺ� �ۼ��ؾ� �ϴ���
 * 
 * �ų׸�( ' <-> ' )�� interface�� �����ϰ�
 * ������ �̸��� �������ش�
 *    ���⿡���� VO. PK��� �̸��� ���Ƿ� �����Ͽ���
 * �׸��� method�� �����Ҷ�
 *   ���׸����� ������ �̸��� ����Ͽ�
 *   return type�� ���� �Ű������� ����Ͽ���
 *   
 *  �̷��� Generic�� ���� interface�� ����� �ΰ�
 *   �Ǵٸ� interface�� ���鶧 �� Generic interface�� ��ӹ޾Ƽ� ����Ѵ�
 *   
 * ��ӹ޴� interface�� ��ӵǴ� ����
 *   �ڽ��� VO, primary key Į���� pk type�� �������ָ�
 *   ����� ��ŵ带 �ٽ� ���� �ʿ䰡 ��������
 *   
 * List<String>
 * List<BookVO>
 */
public interface GenericDao<VO, PK> {
	
	public List<VO> selectAll();
	public void findById(PK pk);
	public int insert(VO vo);
	public int update(VO vo);
	public int delete(PK pk);

}
