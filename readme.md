### 개발 환경
-----------

- IntelliJ IDEA CE
- Gradle 4.10.2
- Java 8
- SpringBoot 2.1.2.RELEASE
  ```jpa, web, rest, security, thymeleaf```

  

### 사용된 외부 라이브러리
--------------------

- Lombok 1.18.4
- Retrofit 2.5.0
- Webjars (jquery, bootstrap)
- H2 Database
- Logback



### 실행 방법
-----------

1. Gradle 빌드
   ```gradle build -x test```

2. Application 실행
   ```java -jar build/libs/build/libs/challenge-0.0.1-SNAPSHOT.jar```

3.  브라우저에서 http://localhost:8081/ 접속 후 아래 테스트 계정 3개중 하나로 로그인
   ```
   test1 / 1024
   test2 / 2048
   test3 / 4096
   ```



### 설명
-------

1. 로그인/아웃
    - 로그인 URL : http://localhost:8082/login
    - 로그아웃 URL : http://localhost:8082/logout

2. 키워드로 장소 검색
    - 접속 URL : http://localhost:8081/view/place/find
    - 검색할 장소를 입력 후 검색버튼 클릭 또는 엔터.
    - PlaceFindService에 

3. 인기 검색어 TOP10
    - 접속 URL : http://localhost:8081/view/place/top10
    - 키워드로 장소 검색시 Interceptor를 통해 검색횟수를 update하고 있다.



### TODO
--------

1. 예외(exception)처리(controller, service 등)
2. Spring Security Token 기반 인증 적용 후 one page 사이트로 전환.
3. 1번을 하지 않는 다면 thymeleaf 템플릿 적용.
4. 장소 상세정보 화면을 좀더 이쁘게(?)

