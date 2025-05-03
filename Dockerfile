# Use official Maven image to build the project
FROM maven:3.9.6-eclipse-temurin-17 AS build

# Set working directory
WORKDIR /app

# Copy the whole project
COPY src .

# Build the application
RUN mvn clean package

# Use lightweight JDK to run the app
FROM eclipse-temurin:17-jdk-jammy

WORKDIR /app

# Copy built JAR from builder stage
COPY --from=build /app/target/my-app-1.0-SNAPSHOT.jar app.jar

# Run the app
ENTRYPOINT ["java", "-jar", "app.jar"]
