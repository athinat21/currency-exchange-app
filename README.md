# Currency Exchange API
## This project implements a Currency Exchange API that allows users to perform currency conversion and retrieve exchange rates.

### Features
##### Swagger Integration: Provides a Swagger UI for easy API testing and documentation. Accessible at /api/swagger-ui.html.
##### GET Endpoint: Retrieve exchange rate details for a specific currency conversion.
##### POST Endpoint: Submit a request with a name and receive a personalized greeting message.
### Getting Started
#### Prerequisites
##### Java Development Kit (JDK) installed on your machine
##### Maven for building and managing the project dependencies
#### Installation
##### Clone this repository to your local machine:



##### bash
##### Copy code
##### cd currency-exchange-api
##### Build the project using Maven:

##### bash
##### Copy code
##### mvn clean install
##### Usage
##### Run the application:

##### bash
##### Copy code
##### java -jar target/currency-exchange-api.jar
##### Once the application is running, you can access the Swagger UI to test the API endpoints:

##### bash
##### Copy code
##### http://localhost:8001/api/swagger-ui.html
##### Use the provided endpoints to perform currency conversions and test the POST request functionality.

#### Endpoints
##### GET /api/simplifyingtech: Retrieve a simple message.

##### GET /currency-conversion/from/{from}/to/{to}/{quantity}: Retrieve exchange rate details for a specific currency conversion.
##### Configuration
##### API Key: Make sure to replace "your_api_key_here" with your actual API key in the APIController.java file.
### Technologies Used
##### Spring Boot
##### Spring Web
##### Spring Test
##### RestTemplate
##### Maven
