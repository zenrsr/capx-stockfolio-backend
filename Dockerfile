# Build stage
FROM maven:3.8.6-openjdk-17-slim AS build  
WORKDIR /app
COPY . .
RUN mvn clean package

# Run stage
FROM eclipse-temurin:17-jre-jammy  
COPY --from=build /app/target/capx-0.0.1-SNAPSHOT.jar /app.jar
CMD ["java", "-jar", "/app.jar"]