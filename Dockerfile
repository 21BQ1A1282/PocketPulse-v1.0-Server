# --- Build Stage ---
# Use a Maven image to build the application JAR
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY . .

# CORRECTED: Move into the "PocketPulse" directory, not "PocketPulse-v1.0"
WORKDIR /app/PocketPulse
RUN mvn clean package

# --- Run Stage ---
# Use a clean JRE image for the final, smaller image
FROM eclipse-temurin:21-jre
WORKDIR /app

# CORRECTED: Adjust the source path to copy the JAR from the correct location
COPY --from=build /app/PocketPulse/target/PocketPulse-0.0.1-SNAPSHOT.jar PocketPulse-v1.0.jar

EXPOSE 9090
ENTRYPOINT ["java", "-jar", "PocketPulse-v1.0.jar"]