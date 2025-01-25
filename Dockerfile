# Build stage
FROM maven:3.8.6-eclipse-temurin-17 AS build
WORKDIR /app

# Cache dependencies separately
COPY pom.xml .
RUN mvn dependency:go-offline -B --fail-never

# Copy source and build
COPY src/ ./src/
RUN mvn clean package -DskipTests

# Final image
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app
RUN adduser --system --group appuser && \
    chown appuser:appuser /app
USER appuser

COPY --from=build --chown=appuser:appuser /app/target/capx-*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]