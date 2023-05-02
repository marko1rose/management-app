FROM openjdk:17
COPY target/movie-service-0.0.1.jar /src/movieservice/
WORKDIR /src/movieservice/
EXPOSE 8081
CMD ["java", "-jar", "movie-service-0.0.1.jar"]