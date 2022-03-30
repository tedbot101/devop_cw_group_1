FROM openjdk:latest
COPY ./target/devop_cw_group_1-0.1.0.1-jar-with-dependencies.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "devop_cw_group_1-0.1.0.1-jar-with-dependencies.jar", "db:3306", "30000"]