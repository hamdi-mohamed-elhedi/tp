FROM openjdk:21-jdk-slim

WORKDIR /app

COPY target/tp-1.0.jar app.jar

EXPOSE 8088

ENTRYPOINT ["java", "-jar", "app.jar", "--server.port=8088"]
``
