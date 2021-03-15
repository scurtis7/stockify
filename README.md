# Stockify

This application will allow you to follow and research stocks.  I use the
[Alpha Vantage API](https://www.alphavantage.co/documentation/#) and 
[Finnhub API](https://finnhub.io/docs/api/#) to get stock information.

## Version 0.0.1
This is the initial version with all of the three main pieces (Spring Boot, Angular9 & Postgresql) working together.
Not much functionality yet just the initial shell of the application.

## Technologies
- Spring Boot - `v2.4.3`
- Java - `v11`
- Angular - `v11.2.4`
- Gradle - `v6.8.3`
- Node - `v15.11.0`
- Typescript - `4.1.5`

## How to run locally
I use a Mac and IntelliJ IDEA so these instructions are for that setup.
After you clone the repository then follow the steps below.

### Build the Angular application
To build the Angular application follow the following steps:
- open a terminal
- navigate to `stockify/src/webapp`
- install angular dependencies with this command `npm install` (you only have to do this once)
- run the following command `npm run build`

### Build the spring boot application
Next build the Spring Boot application with these steps:
- open a terminal
- navigate to `stockify/`
- run the following command `./gradlew clean build`

### Start the application
Once the application is built you can run it with the following command:
- In the terminal from the same location you ran the build from
- run the following command `./gradlew bootRun`
- navigate to the [Stockify application](http://localhost:8080)

**NOTE:** You can also build and run the application from IntelliJ
