# Use a base image with Maven and Java
FROM maven:3.8.6-openjdk-17 AS build

# Copy the project files
WORKDIR /app
COPY . .

# Build the JAR
RUN mvn clean package

# Use a lightweight Java runtime image
FROM openjdk:17-jdk-slim

# Copy the JAR from the build stage
COPY --from=build /app/target/capx-0.0.1-SNAPSHOT.jar /app.jar

# Run the application
CMD ["java", "-jar", "/app.jar"]