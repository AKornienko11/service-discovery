FROM maven:3.9.6-eclipse-temurin-17 AS builder
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Было: FROM openjdk:17-jdk-slim
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app
COPY --from=builder /app/target/service-discovery-0.0.1-SNAPSHOT.jar service-discovery.jar
EXPOSE 8098
ENTRYPOINT ["java", "-jar", "service-discovery.jar"]