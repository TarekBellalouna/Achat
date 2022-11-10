FROM openjdk:8-jdk-alpine
ADD http://192.168.1.7:8081/repository/maven-releases/tn/esprit/rh/achat/1.0/achattarek.jar achattarek.jar
EXPOSE 8089
ENTRYPOINT ["java", "-jar", "achattarek.jar"]