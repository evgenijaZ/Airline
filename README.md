# Airline
This repository contains the console application "Airline". 
There is a three-level hierarchy of aircraft classes ( the Aircraft class, 
the Airship class, the Helicopter class, the Airplane class, 
the PassengerPlane class, the CargoPlane class), 
the Airline class, the Menu class, and the main class is the Application class.  
The diagram of classes is presented below.  
![Diagram of classes](https://github.com/evgenijaZ/Airline/raw/master/docs/classDiagram.png)  
An airline company can store airplanes, it can be passenger, cargo, or simply airplanes. 
If the Airplane class has other heirs, they can also be stored in the Airline. 
It also has methods for calculating total capacity and carrying capacity of all the aircraft in the airline,
for sorting the airplanes by flight range (from smaller to larger) 
and for filtering airplanes corresponding to the specified range of fuel consumption parameters (liters per hour).  
##Getting started  
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.  
###Prerequisites  
In order to install and run the project you must have installed [Java 8](https://www.java.com/en/download/help/download_options.xml) and [Maven](https://maven.apache.org/install.html).  
###Installing
Download and unzip this repository, or clone it using Git:  
`git clone https://github.com/evgenijaZ/Airline.git`