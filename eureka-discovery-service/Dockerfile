FROM openjdk:8-jdk-alpine
WORKDIR /
ADD target/eureka-discovery-service-0.0.1-SNAPSHOT.jar eureka.jar
EXPOSE 8761
CMD java -jar eureka.jar