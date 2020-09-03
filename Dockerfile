##
## MAVEN JAR BUILD
##
FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/app/survey_picture_service/src
COPY pom.xml /home/app/survey_picture_service
RUN mvn -f /home/app/survey_picture_service/pom.xml clean package

##
## Compile App
##
FROM openjdk:8-jdk-alpine as builder
COPY --from=build /home/app/survey_picture_service/target/*.jar /usr/app/survey_picture_service.jar
EXPOSE 8761
ENTRYPOINT ["java", "-jar", "/usr/app/survey_picture_service.jar"]
