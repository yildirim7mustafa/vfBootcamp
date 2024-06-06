FROM openjdk:17
EXPOSE 8080
ADD target/vfbootcamp.jar vfbootcamp.jar
ENTRYPOINT ["java", "-jar", "/vfbootcamp.jar"]