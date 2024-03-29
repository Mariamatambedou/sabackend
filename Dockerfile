FROM maven:3.9.0-eclipse-temurin-17 as build
WORKDIR /app
COPY . .
RUN mvn clean install

FROM eclipse-temurin:17.0.6_10-jdk
WORKDIR /app
COPY --from=build /app/target/sa-backend-0.0.1-SNAPSHOT.jar /app/
EXPOSE 8080
CMD ["java", "-jar","sa-backend-0.0.1-SNAPSHOT.jar"]
