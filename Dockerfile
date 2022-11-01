FROM openjdk:8-jdk-alpine
ADD target/achat-1.0.jar achattarek.jar
EXPOSE 8089
ENTRYPOINT ["java", "-jar", "achattarek.jar"]