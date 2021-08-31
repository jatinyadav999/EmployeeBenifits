# FROM openjdk:8
# EXPOSE 8080
# ADD target/employee-docker.jar employee-docker.jar
# ENTRYPOINT ["java","-jar","/employee-docker.jar"]
FROM openjdk:11.0.11
LABEL maintainer="jatinyadav247@gmail.com"
VOLUME /main-app
ADD target/employee-docker.jar employee-docker.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar","/employee-docker.jar"]
