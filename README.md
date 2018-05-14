# Airline  
[![Build Status](https://travis-ci.org/evgenijaZ/Airline.svg?branch=master)](https://travis-ci.org/evgenijaZ/Airline)  
This repository contains the console application and RESTful web service "Airline". 

## Console application  
There is a three-level hierarchy of aircraftList classes ( the Aircraft class, 
the Airship class, the Helicopter class, the Airplane class, 
the PassengerPlane class, the CargoPlane class), 
the Airline class, the Menu class, and the main class is the Application class.  
The diagram of classes is presented below.  
![Diagram of classes](https://github.com/evgenijaZ/Airline/raw/master/docs/classDiagram.png)  
An airline company can store airplanes, it can be passenger, cargo, or simply airplanes. 
If the Airplane class has other heirs, they can also be stored in the Airline. 
It also has methods for calculating total passengerCapacity and carrying passengerCapacity of all the aircraftList in the airline,
for sorting the airplanes by flight range (from smaller to larger) 
and for filtering airplanes corresponding to the specified range of fuel consumption parameters (liters per hour).  

##RESTful web service

### Getting started  
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.  
#### Prerequisites  
To install and run the project, make sure that you have [Java 8](https://www.java.com/en/download/help/download_options.xml)(or higher) and [Maven](https://maven.apache.org/install.html) installed.  
#### Installing
Download and unzip this repository, or clone it using Git:  
```
git clone https://github.com/evgenijaZ/Airline.git  
```  

### Running  
On your command line in project folder, execute the following Maven goal to build app:  
```
mvn package
```  
You may run compiled and packaged JAR with the following command:
```
mvn exec:java
```  
For running JAR of *REST WS* use:  
```
java -jar target/airline-app-2.0.jar
```

If you are using Maven, you can run the application using ```./mvnw spring-boot:run```
It should be available under [http://localhost:8080](http://localhost:8080)  

#### REST API Usage  
*URL*: [/airlines](http://localhost:8080/airlines)  
*Method*: GET  
*MediaType*:  application_json  
*Description*: Get all airlines  

*URL*: [/airlines/{id}](http://localhost:8080/airlines/1)  
*Method*: GET  
*MediaType*:  application_json  
*Description*: Get airline by id 

*URL*: [/airlines/{id}/aircraft](http://localhost:8080/airlines/1/aircraft)  
*Method*: GET  
*MediaType*:  application_json  
*Description*: Get list of all aircraft of the airline by airline id  

*URL*: [/airlines/{id}/aircraft](http://localhost:8080/airlines/1/aircraft)  
*Method*: POST  
*MediaType*:  application_json  
*Description*: Add aircraft to the airline by airline id  
*Request body example*:  
```json
{"modelName":"Boeing 747-400F","passengerCapacity":0,"carryingCapacity":396890,"flightRange":8230,"fuelConsumption":1350.0,"cruisingSpeed":980,"cargoWeight":300000,"flying":false}
```

*URL*: [/airlines/{id}/aircraft/sorted-by-flight-range](http://localhost:8080/airlines/1/aircraft/sorted-by-flight-range)  
*Method*: GET  
*MediaType*:  application_json  
*Description*: Get sorted by flight range list of all aircraft of the airline by airline id  

*URL*: [/airlines/{id}/aircraft/filtered-by-fuel-consumption](http://localhost:8080/airlines/1/aircraft/filtered-by-fuel-consumption?min=0&max=10000)  
*Method*: GET  
*MediaType*:  application_json  
*Parameters*: min, max  
*Description*: Get filtered by fuel consumption ( from *min* to *max* ) list of aircraft of the airline by airline id  

*URL*: [/airlines/{id}/aircraft/filtered-by-passenger-capacity-and-flight-range](http://localhost:8080/airlines/1/aircraft/filtered-by-passenger-capacity-and-flight-range?capacity=100&range=5000)  
*Method*: GET  
*MediaType*:  application_json  
*Parameters*: min, max  
*Description*: Get filtered by passenger capacity and flight range (in km/h) list of aircraft of the airline by airline id  

*URL*: [/airlines/{id}/total-passenger-capacity](http://localhost:8080/airlines/1/total-passenger-capacity)   
*Method*: GET  
*MediaType*:  application_json  
*Description*: Get total passenger capacity of the airline by airline id  

*URL*: [/airlines/{id}/total-carrying-capacity](http://localhost:8080/airlines/1/total-carrying-capacity)   
*Method*: GET  
*MediaType*:  application_json  
*Description*: Get total carrying capacity of the airline by airline id  


### Running tests
Folder [src/test](src/test) contains automated tests for this application.
You may run it separatuly, using following command:  
```
mvn test
```

## Links  
General documentation - [Javadoc](https://evgenijaz.github.io/Airline/)