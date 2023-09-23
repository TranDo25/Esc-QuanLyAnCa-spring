# syntax=docker/dockerfile:1

#which official image
FROM openjdk:oraclelinux8
#working directory
WORKDIR /app
#copy from your host(PC, laptop) to container
COPY .mvn/ .mvn
COPY mvnw pom.xml ./

#run this image inside the image
RUN ./mvnw dependency:go-offline
COPY src ./src
#run inside container
CMD ["./mvnw","spring-boot:run"]

