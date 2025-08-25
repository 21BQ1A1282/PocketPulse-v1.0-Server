# --- Build Stage ---
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package

# --- Run Stage ---
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/target/PocketPulse-0.0.1-SNAPSHOT.jar PocketPulse-v1.0.jar
EXPOSE 9090
ENTRYPOINT ["java", "-jar", "PocketPulse-v1.0.jar"]