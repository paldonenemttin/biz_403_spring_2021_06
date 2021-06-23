# Spring MyBatis Project

### Dependency 설정
* mybatis : 최신버전
* mybatis-spring : 최신버선
* commons-dbcp2 : 최신버전(commons-dbcp 와 다름)

### commons-dbcp2
* apache재단에서 만든 DB Connection도구
* DB 연결을 pool사용하여 많은 동시 접속을 효율적으로 처리
* 기본적으로 DB 연결 Connection 미리 다수(10)개를 만들어두고  
연결 요청이 오면 그중 1개를 연결하는 통로로 제공

### mybatis
* mybatis는 DB연동과 관련된 상당히 많은 부분의 코드를 직접 작성않고  
수행할 수 있도록 도와주는 DB연결 라이브러리
* 현재 진행형의 DB연동이 이루어지는 Spring Project에서는  
거의  mybatis를 활용한 DB연결이 이루어 진다

# Spring DB연동 프로젝트 작성
1. 기본 Spring MVC 프로젝트 생성
2. pom.xml에 Spring관련 기본 Dependency설정
3. mybatis 관련 Dependency 설정
4. 여기까지 기본 프로젝트가 정상적으로 구동되는지 확인하기
5. mybatis-context.xml 작성하기
6. DBMS에 table 생성하기 테스트용 데이터 insert
7. model class(VO, DTO) 생성하기
8. Dao 생성하기, Service 생성하기 Controller 생성하기
9. client에서 Request하여 Controller에 요청하고  
데이터가 정상적으로 select되는지 log를 통해서 확인


