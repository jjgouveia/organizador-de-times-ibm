FROM maven:3.8.5-openjdk as build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/*.jar organizador-de-times.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]