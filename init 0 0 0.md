# init : 0.0.0

---

***applcation.yml***

```yaml
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    username: siuki
    password: Ssw0304!
    url: jdbc:mysql://localhost:3306/security20230725
  jpa:
    database-platform: org.hibernate.dialect.MySQL5InnoDBDialect
    hibernate:
      ddl-auto: update
    show-sql: 'true'
```

***build.gradle - dependency***

```java
dependencies {
	implementation 'org.springframework.boot:spring-boot-starter-data-jdbc'
	implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
	implementation 'org.springframework.boot:spring-boot-starter-jdbc'
	implementation 'org.springframework.boot:spring-boot-starter-security'
	implementation 'org.springframework.boot:spring-boot-starter-web'
	compileOnly 'org.projectlombok:lombok'
	developmentOnly 'org.springframework.boot:spring-boot-devtools'
	runtimeOnly 'com.mysql:mysql-connector-j'
	annotationProcessor 'org.projectlombok:lombok'
	testImplementation 'org.springframework.boot:spring-boot-starter-test'
	testImplementation 'org.springframework.security:spring-security-test'

	// https://mvnrepository.com/artifact/com.auth0/java-jwt
	implementation group: 'com.auth0', name: 'java-jwt', version: '4.2.1'

	// jasypt
	implementation 'com.github.ulisesbocchio:jasypt-spring-boot-starter:3.0.4'
}
```

<aside>
<img src="https://raw.githubusercontent.com/eirikmadland/notion-icons/master/v5/icon3/mi-cloud.svg" alt="https://raw.githubusercontent.com/eirikmadland/notion-icons/master/v5/icon3/mi-cloud.svg" width="40px" /> JWT - Libraray

---

// jwt

implementation group: 'com.auth0', name: 'java-jwt', version: '4.2.1'

</aside>

<aside>
<img src="https://raw.githubusercontent.com/eirikmadland/notion-icons/master/v5/icon3/mi-cloud.svg" alt="https://raw.githubusercontent.com/eirikmadland/notion-icons/master/v5/icon3/mi-cloud.svg" width="40px" /> jasypt

---

// jasypt
implementation 'com.github.ulisesbocchio:jasypt-spring-boot-starter:3.0.4'

</aside>

![Untitled](init%200%200%200%204d29c4677015465e80dcfdc785b2d4e0/Untitled.png)

[SpringSecurity_JWT_PRACTICE-2023-07-25.zip](init%200%200%200%204d29c4677015465e80dcfdc785b2d4e0/SpringSecurity_JWT_PRACTICE-2023-07-25.zip)

<aside>
<img src="https://raw.githubusercontent.com/eirikmadland/notion-icons/master/v5/icon3/mi-cloud.svg" alt="https://raw.githubusercontent.com/eirikmadland/notion-icons/master/v5/icon3/mi-cloud.svg" width="40px" /> 결과

---

→ jwt 라이브러리와 jasypt 라이브러리를 추가

→ README 추가 

</aside>

![Untitled](init%200%200%200%204d29c4677015465e80dcfdc785b2d4e0/Untitled%201.png)