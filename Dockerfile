FROM openjdk:11
EXPOSE 8080
ADD target/springBoot-docker.jar  springBoot-docker.jar
ENTRYPOINT ["java",".jar","/springBoot-docker.jar"]                                                           