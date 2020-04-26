# SpringBoot : Spring Boot + Hibernate+ Mysql+ docker 


### Deploying SpringBoot Applications

**spring-bank-branch-service-docker**: This module demonstrates running SpringBoot application in Docker container.

#### How to run?

spring-bank-branch-service-docker> mvn spring-boot:run

## Running on Docker container

Build the docker image using maven

spring-bank-branch-service-docker> mvn clean package docker:build

### Running MySQL and Application containers individually


*Run mysql :*

docker run -d --name branch-service -e MYSQL_ROOT_PASSWORD=secret123 -e MYSQL_DATABASE=branch-service -e MYSQL_USER=dbuser -e MYSQL_PASSWORD=secret mysql:latest

*Run application linking to demo-mysql container:*

docker run -d --name spring-bank-branch-service-docker -e "SPRING_PROFILES_ACTIVE=docker" --link branch-service:mysql -p 8080:8080 rkp/spring-bank-branch-service-docker

http://localhost:8080/branch


### Running MySQL and Application using docker-compose


Navigate to the directory where docker-compose.yml file is there.

spring-bank-branch-service-docker> docker-compose up
http://localhost:8080/branch
http://localhost:8080/
http://127.0.0.1:8080/branch