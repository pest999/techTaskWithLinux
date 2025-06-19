FROM maven:3.8.6-eclipse-temurin-17

# Install bc calculator
RUN apt-get update && \
    apt-get install -y bc && \
    rm -rf /var/lib/apt/lists/*

# Set working directory
WORKDIR /app

# Copy pom.xml first to cache dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy source code
COPY src ./src

# Run tests
CMD ["mvn", "clean", "test"] 