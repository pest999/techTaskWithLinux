# BC Calculator Tests

Tests for Linux `bc` calculator with Allure reporting.

## What we test
Basic arithmetic operations and error handling.

## Requirements

**Linux:**
- Java 17+, Maven, bc calculator

**Windows:**
- Docker Desktop

## Installation

**Linux:**
```bash
sudo apt-get install openjdk-17-jdk maven bc
```

**Windows:**
Install Docker Desktop from docker.com

## Running Tests

**Linux:**
```bash
chmod +x run-tests.sh
./run-tests.sh
```

**Windows:**
```batch
run-tests-docker.bat
```

## Technology Stack
- Java 17
- JUnit 5
- Maven
- Allure reporting
- Docker (Windows)

## Test Coverage
- Basic arithmetic (+, -, *, /)
- Error handling (division by zero)
- Large numbers and precision 