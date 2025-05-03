

# Use OpenJDK base image
FROM openjdk:17-alpine

# Set working directory inside container
WORKDIR /app

# Copy your JAR file into the image
COPY out/artifacts/your-jar-file.jar app.jar

# Run the application
CMD ["java", "-jar", "app.jar"]
