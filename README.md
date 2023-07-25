# SpringSecurity_JWT_PRACTICE : 하찮은 오후 유튜브 따라하기
Java Version : 11
build tool   : gradle

Dependency 
dependencies {

	// jdbc
	implementation 'org.springframework.boot:spring-boot-starter-data-jdbc'

 	// jpa
	implementation 'org.springframework.boot:spring-boot-starter-data-jpa'

 	// jdbc
	implementation 'org.springframework.boot:spring-boot-starter-jdbc'

 	// security
	implementation 'org.springframework.boot:spring-boot-starter-security'

 	// web
	implementation 'org.springframework.boot:spring-boot-starter-web'

 	// lombok
	compileOnly 'org.projectlombok:lombok'

 	// devtools
	developmentOnly 'org.springframework.boot:spring-boot-devtools'

 	// mysql connector
	runtimeOnly 'com.mysql:mysql-connector-j'

 	// lombok
	annotationProcessor 'org.projectlombok:lombok'

 	// boot test
	testImplementation 'org.springframework.boot:spring-boot-starter-test'
 	
  	// security test
	testImplementation 'org.springframework.security:spring-security-test'

	// https://mvnrepository.com/artifact/com.auth0/java-jwt
	implementation group: 'com.auth0', name: 'java-jwt', version: '4.2.1'

	// jasypt
	implementation 'com.github.ulisesbocchio:jasypt-spring-boot-starter:3.0.4'
}



