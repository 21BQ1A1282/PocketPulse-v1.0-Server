FROM eclipse-temurin:21-jre
WORKDIR /app
COPY PocketPulse/target/PocketPulse-0.0.1-SNAPSHOT.jar PocketPulse-v1.0.jar
EXPOSE 9090
ENTRYPOINT ["java", "-jar", "PocketPulse-v1.0.jar"]