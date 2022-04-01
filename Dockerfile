FROM openjdk:latest
COPY ./target/DevOps_Group_1_App.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "DevOps_Group_1_App.jar", "db:3306", "30000"]
