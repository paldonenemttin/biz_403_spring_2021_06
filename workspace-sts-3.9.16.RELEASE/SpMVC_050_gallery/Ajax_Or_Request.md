# web에서 server에 요청하기

## Request로 요청하고 Response로 받기
* Server의 controller에게 요청을 하고, 이때 데이터도 보낼 수 있다
* Server에게 요청을 하면 server는 web에게 보여줄 데이터를 준비하고  
데이터를 가공하여 보기 좋게 UI까지 구성하여 Response한다
* 전통적인 Client/Server Web App의 호출(flow)이다
* 어떤 방식으로 Server에게 요청을 하든 서버는 결국 자신의 view와 데이터를 결합하여  
사용하게(Web) HTML의 결과를 Response한다

## Ajax(Fetch)로 요청하고 Response로 받기
* web의 스크립트에서 서버의 controller에게 요청을 하고 이때 데이터도 보낼 수 있다
* ajax로 요청을 할때는 서버가 현식이 갖추어진 데이터(XML,JSON)을 응답하고  
뒷 일은 웹의 스크립트에서 처리한다는 무언의 약속이 있다

* web에서 요청을 할때 단순한 요청(ex delete)을 하면 요청한 데이터에 미리 서버에서 처리를 수행하고  
응답은 성공 실패 또는 기타등의 단순한 메시지만 보내게 된다

* web에서는 단순한 응답을 받고, script를 사용하여 다른 일들을 수행한다

* ajax로 요청을 한다는것은 서버로 부터 단순한 응답을 받을 것을 기대하고 요청을 하게 된다