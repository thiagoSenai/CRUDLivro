FROM openjdk:latest

EXPOSE 8085

RUN apt-get update 
RUN apt-get install -y maven
RUN apt-get install -y git-all 
RUN git clone https://github.com/thiagoSenai/CRUDLivro.git
COPY pom.xml /usr/local/service/pom.xml
COPY src /usr/local/service/src
WORKDIR /usr/local/service
RUN mvn clean install -DskipTests
CMD ["java", "-cp", "target/CRUDLivro-1.0-SNAPSHOT.jar.original"]
