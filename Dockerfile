FROM openjdk:8
ADD http://192.168.1.22:8081/repository/maven-releases/tn/esprit/rh/achat/1.0/achat-1.0.jar achat-1.0.jar
EXPOSE 8089
ENTRYPOINT ["java", "-jar", "/achat-1.0.jar"]