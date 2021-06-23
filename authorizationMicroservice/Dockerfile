FROM openjdk:8-jdk-alpine
WORKDIR /
ADD target/authorizationMicroservice-0.0.1-SNAPSHOT.jar authorization.jar
EXPOSE 5100
CMD java -jar authorization.jar