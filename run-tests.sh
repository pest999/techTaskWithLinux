#!/bin/bash

echo "Running Calculator Tests..."

# Check basic requirements
if ! command -v bc &> /dev/null; then
    echo "Error: bc not found. Install with: sudo apt-get install bc"
    exit 1
fi

if ! command -v mvn &> /dev/null; then
    echo "Error: Maven not found. Install with: sudo apt-get install maven"
    exit 1
fi

# Run tests
mvn clean test

# Generate Allure report if tests ran
if [ -d "target/allure-results" ]; then
    echo "Generating Allure report..."
    mvn allure:serve
else
    echo "No test results found"
fi 