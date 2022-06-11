FROM openjdk:11
EXPOSE 8084
ADD target/docker-jenkins-integration-sample.war docker-jenkins-integration-sample
ENTRYPOINT ["java", "-jar", "/docker-jenkins-integration-sample.war"]