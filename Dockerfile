FROM eclipse-temurin:21-jre
ADD target/PocketPulse-v1.0.jar PocketPulse-v1.0.jar
EXPOSE 9090
ENTRYPOINT ["java", "-jar", "/PocketPulse-v1.0.jar"]