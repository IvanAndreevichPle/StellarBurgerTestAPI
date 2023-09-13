# Install maven and copy project for compilation
FROM maven:latest as builder

COPY pom.xml /usr/local/pom.xml
COPY server /usr/local/server
COPY client /usr/local/client
WORKDIR /usr/local/

RUN mvn clean install