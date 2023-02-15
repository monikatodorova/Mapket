# Use a Java runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory to /app
WORKDIR /app

# Copy the executable jar file and the database initialization script into the container
COPY target/myapp.jar .

# Install PostgreSQL client
RUN apt-get update && \
    apt-get install -y postgresql-client

# Define environment variables for the database connection
ENV DB_URL jdbc:postgresql://0.0.0.0:5432/mapket
ENV DB_USERNAME postgres
ENV DB_PASSWORD Filip123!

# Expose the port on which the application will run
EXPOSE 8080

# Start the application and execute the database initialization script
CMD java -jar myapp.jar && psql $DB_URL -U $DB_USERNAME