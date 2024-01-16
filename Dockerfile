# Use the official OpenJDK base image with a suitable tag
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the Spring Boot application JAR file into the container
COPY target/graphq-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your application listens on
EXPOSE 8080

# Specify the command to run your application
CMD ["java", "-jar", "app.jar"]
