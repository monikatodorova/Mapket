# Use official PostgreSQL image as a parent image
FROM postgres:13

# Set environment variables
ENV POSTGRES_DB mapket
ENV POSTGRES_USER postgres
ENV POSTGRES_PASSWORD Filip123!

# Copy initialization script
# COPY init.sql /docker-entrypoint-initdb.d/

# Expose PostgreSQL default port
EXPOSE 5432

# Start PostgreSQL server
CMD ["postgres"]