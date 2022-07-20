#define base docker image
FROM openjdk:17
LABEL maintainer ="Vladi"
ADD target/TaskManager-1.0-SNAPSHOT.jar springboot-docker.jar
ENTRYPOINT ["java","-jar","springboot-docker.jar"]