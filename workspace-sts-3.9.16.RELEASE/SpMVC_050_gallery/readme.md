# Spring file upload project
* web-client���� ���ε� �Ҷ� �ʿ��Ѱ�

## �ʿ��� dependency

	<!-- https://mvnrepository.com/artifact/commons-fileupload/commons-fileupload -->
	<dependency>
	    <groupId>commons-fileupload</groupId>
	    <artifactId>commons-fileupload</artifactId>
	    <version>1.4</version>
	</dependency>
	<!-- https://mvnrepository.com/artifact/commons-io/commons-io -->
	<dependency>
	    <groupId>commons-io</groupId>
	    <artifactId>commons-io</artifactId>
	    <version>2.10.0</version>
	</dependency>


## root-context.xml�� ���� ���ε� ����
<!-- Root Context: defines shared resources visible to all other web components -->
	<!-- file upload�� ���õ� bean�� �����ϱ� -->
	<!-- 
	����
	0: ��
	000:k
	000,000:m
	000,000,000:g
	000,000,000,000: T -->
	
	<bean id="multipartresolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
	 	<property name="maxUploadSize" value="10000000"/>
	 	<property name="maxUploadSizePerFile" value="10000000"/>
	</bean>
	
* maxUploadterFile: ���� 1�� �뷮 ����
* maxUploadSizePerFile: ���� ��ü ���� �뷮 ����