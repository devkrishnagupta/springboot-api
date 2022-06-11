FROM openjdk:8
EXPOSE 8084
ADD target/docker-jenkins-integration-sample.jar docker-jenkins-integration-sample
ENTRYPOINT ["java", "-jar", "/docker-jenkins-integration-sample.jar"]