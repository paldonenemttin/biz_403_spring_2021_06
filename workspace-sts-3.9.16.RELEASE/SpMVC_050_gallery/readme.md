# Spring file upload project
* web-client에서 업로드 할때 필요한거

## 필요한 dependency

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


## root-context.xml에 파일 업로드 설정
<!-- Root Context: defines shared resources visible to all other web components -->
	<!-- file upload와 관련돤 bean을 설정하기 -->
	<!-- 
	단위
	0: 개
	000:k
	000,000:m
	000,000,000:g
	000,000,000,000: T -->
	
	<bean id="multipartresolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
	 	<property name="maxUploadSize" value="10000000"/>
	 	<property name="maxUploadSizePerFile" value="10000000"/>
	</bean>
	
* maxUploadterFile: 파일 1개 용량 제한
* maxUploadSizePerFile: 파일 전체 파일 용량 제한