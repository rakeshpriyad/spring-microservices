FROM java:8
ARG JAR_FILE=target/branch-service-k8-mysql.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=docker","-jar","/app.jar"]
EXPOSE 8080