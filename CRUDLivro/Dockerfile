FROM openjdk:latest

EXPOSE 8085

RUN apt-get update 
RUN apt-get install -y maven
COPY pom.xml /usr/local/service/pom.xml
COPY src /usr/local/service/src
WORKDIR /usr/local/service
RUN mvn clean install -DskipTests
CMD ["java", "-cp", "target/CRUDLivro-1.0-SNAPSHOT.jar"]
