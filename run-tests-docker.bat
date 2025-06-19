@echo off
echo ==========================================
echo   Calculator Tests with Docker + Allure   
echo ==========================================
echo.

echo 1. Checking Docker and cleaning up...
docker info > nul 2>&1
if errorlevel 1 (
    echo Docker is not running! Please start Docker Desktop.
    pause
    exit /b 1
)

docker rm -f bc-calculator-tests 2>nul
docker rmi bc-calculator-tests 2>nul

echo 2. Building and running tests in Docker...
docker build --no-cache -t bc-calculator-tests .
if errorlevel 1 (
    echo Failed to build Docker image!
    pause
    exit /b 1
)

if not exist "target" mkdir target
docker run --name bc-calculator-tests bc-calculator-tests

echo 3. Copying results and cleaning up...
docker cp bc-calculator-tests:/app/target/allure-results/. ./target/allure-results/ 2>nul
docker cp bc-calculator-tests:/app/target/surefire-reports/. ./target/surefire-reports/ 2>nul

docker rm bc-calculator-tests
docker rmi bc-calculator-tests

echo 4. Generating and serving Allure report...
if not exist "target\allure-results\*.json" (
    echo No Allure results found!
    echo Check Docker logs above for issues
    pause
    exit /b 1
)

call mvn allure:serve

pause 