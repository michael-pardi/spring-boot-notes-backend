# spring-boot-notes-backend
A notes app using Spring Boot as a back-end java service layer

### Installing
1. Clone this repository
2. Run `mvn clean install` to build and download dependencies
3. Run `mvn spring-boot:run` to start Spring Boot application

### Use
1. Hit endpoint `localhost:8080/oath/token` to properly authenticate as a user (requires user to be added to tables first).
2. Use OATH2.0 token to access other endpoints.
