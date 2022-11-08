FROM openjdk:8-jdk-alpine
ADD target/achattarek.jar achattarek.jar
EXPOSE 8089
ENTRYPOINT ["java", "-jar", "achattarek.jar"]