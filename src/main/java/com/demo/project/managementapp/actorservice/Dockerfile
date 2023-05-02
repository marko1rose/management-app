FROM openjdk:17
COPY target/actor-service-0.0.1.jar /src/actorservice/
WORKDIR /src/actorservice/
EXPOSE 8080
CMD ["java", "-jar", "actor-service-0.0.1.jar"]