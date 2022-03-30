FROM openjdk:latest
COPY ./target/app.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "app.jar"]
