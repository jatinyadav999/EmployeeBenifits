FROM openjdk:8
EXPOSE 8080
ADD target/employee-docker.jar employee-docker.jar
ENTRYPOINT ["java","-jar","/employee-docker.jar"]
