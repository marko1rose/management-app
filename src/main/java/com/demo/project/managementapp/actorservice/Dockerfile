FROM openjdk:17
COPY target/actorservice-0.0.1.jar /src/actorservice/
WORKDIR /src/actorservice/
EXPOSE 8080
CMD ["java", "-jar", "actorservice.jar"]