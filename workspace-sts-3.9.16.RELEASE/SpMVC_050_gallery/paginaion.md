# pagination
* 많은 dataList가 select 되었을때 전체 리스트를 한 화면에 보여주면  
보는데 상당한 애로사항이 있을것
* 한 화면에 일정 list의 문장만 부여주고
* list 하단에 page navigation을 표현하여
* page num을 클릭하면 이후 list를 조회하여 보여주는 방식

# pagination 설계할 시 요구사항
* 한 화면에 몇개의 list를 보여줄 것인가 : 보통  10개
* page navigation의 갯수를 몇개로 할 것인가 : 보통 5개 또는 10개
* 처음으로 가기 : 1page list 보기
* 끝으로 가기 : 제일 마지막 list 보이기
* 이전으로 이후로 가기 : 현재 보고 있는 page에서 앞, 뒤로가기

* 보고 있는 화면에서 page navigation 번호를 클릭했을때 controller에서 전달하는 값  
pageNum만 전달하기 검색어와 함계 전달하기 검색어 정렬기준와 함계 전달하기

## 이 프로젝트에서 pagination구현하기
* sql의 select는 표준 sql select만 사용하기
* java code에서 pagination  구현
* 1.8 미만에서 사용하는 코드, 1.8 이상에서 구현하는 코드
* 1.8 이상의 코드: Lambda, Stream(Listdata에 해당)