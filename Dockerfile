FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY . .
WORKDIR /app/PocketPulse
RUN mvn clean package

FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/PocketPulse/target/PocketPulse-0.0.1-SNAPSHOT.jar PocketPulse-v1.0.jar
EXPOSE 9090
ENTRYPOINT ["java", "-jar", "PocketPulse-v1.0.jar"]