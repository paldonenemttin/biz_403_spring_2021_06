# Spring MyBatis Project

### Dependency ����
* mybatis : �ֽŹ���
* mybatis-spring : �ֽŹ���
* commons-dbcp2 : �ֽŹ���(commons-dbcp �� �ٸ�)

### commons-dbcp2
* apache��ܿ��� ���� DB Connection����
* DB ������ pool����Ͽ� ���� ���� ������ ȿ�������� ó��
* �⺻������ DB ���� Connection �̸� �ټ�(10)���� �����ΰ�  
���� ��û�� ���� ���� 1���� �����ϴ� ��η� ����

### mybatis
* mybatis�� DB������ ���õ� ����� ���� �κ��� �ڵ带 ���� �ۼ��ʰ�  
������ �� �ֵ��� �����ִ� DB���� ���̺귯��
* ���� �������� DB������ �̷������ Spring Project������  
����  mybatis�� Ȱ���� DB������ �̷�� ����

# Spring DB���� ������Ʈ �ۼ�
1. �⺻ Spring MVC ������Ʈ ����
2. pom.xml�� Spring���� �⺻ Dependency����
3. mybatis ���� Dependency ����
4. ������� �⺻ ������Ʈ�� ���������� �����Ǵ��� Ȯ���ϱ�
5. mybatis-context.xml �ۼ��ϱ�
6. DBMS�� table �����ϱ� �׽�Ʈ�� ������ insert
7. model class(VO, DTO) �����ϱ�
8. Dao �����ϱ�, Service �����ϱ� Controller �����ϱ�
9. client���� Request�Ͽ� Controller�� ��û�ϰ�  
�����Ͱ� ���������� select�Ǵ��� log�� ���ؼ� Ȯ��


