# WAS(Web Application Service, Web Application Server:tomcat)���� HTTP Status �ڵ�

## �������� Request�� Response�� �̷�� ������
* 200 : ���� �Ϻ��� ����
* 300 : Redirection�� �ǰų�, ���� ����� ������ ��� �϶�

## Request�� �߸�������
* 404 : URI�� �߸� ��û������,  
Tomcat SEver�� method���� Rendering�� jsp������ �� ã������(�޽����� ���Եȴ�)

* 405 : Request�� uri�� mapping�� ã�� �� ������, RequestMethod�� �ش��ϴ� �׸��� ������

* 400 : ������ �����͸� �����ߴµ�, ������ Ÿ���� �߸����� ���  
��) java method�� �Ű������� �������δ� �����ϴµ����Ϳ� ����, ���ڿ�, null���� ���ԵǾ� �ִ� ���

## ���� ���� ����
* 500: ���ο��� �ڵ尡 ����Ǵ� ���� Exception�� �߻��ϴ� ���  
�����޽����� �����Ͽ� �� ã�ƾ� �Ѵ�  
�����ڰ� ���� �ڵ� �޽��� ã��, exception ���� �����ϱ�