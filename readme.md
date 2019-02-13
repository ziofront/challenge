### 개발 환경

-----

- IntelliJ IDEA CE

- Gradle 4.10.2

- Java 8

- SpringBoot 2.1.2.RELEASE

  ```jpa, web, rest, security```

  

### 사용된 외부 라이브러리

- Lombok 1.18.4
- Retrofit 2.5.0
- Webjars (jquery, bootstrap)
- Logback
- H2 Database



### 실행 방법

-----

1. Grade 빌드

   ```gradle build -x test```

2. Application 실행

   ```java -jar build/libs/build/libs/challenge-0.0.1-SNAPSHOT.jar```

3.  브라우저에서 http://localhost:8081/ 접속 후 아래 테스트 계정 3개중 하나로 로그인

   ```
   test1 / 1024
   test2 / 2048
   test3 / 4096
   ```