### Introduction to the Tea Shop Assignment:
***

This project was created as part of my Object-Oriented Development Class. The project is a simplified teashop 
application that allows users to browse teas by selecting filters (in stock, name contains, price above/below, etc.)

## Key Concepts
***
This project is meant to demonstrate the following concepts in Object Oriented Design:
* SRP to keep classes focused on a single responsibility
* OCP to extend existing behavior without modifying core logic 
* The strategy pattern to encapsulate and dynamically choose payment behavior
* The decorator pattern to compose filters at run time allowing for dynamically created filters
* Separating domain logic from UI logic
* Use of polymorphism and dynamic dispatch instead of type checking
* Protecting internal state through encapsulation
* Creation of a medium size application into cohesive classes

## How To Run
***
There are 2 main ways to run this application:

* Docker:
  * What You'll Need:
    * Docker
  * Instructions to Build & Run the Application:
    * Clone the repository using `git clone https://github.com/copelansam/TeaShop`
    * Navigate to the root directory of the repository
    * Ensure you have docker running
    * Build the Docker image from the CLI using `docker build -t tea-shop-app:latest .`
    * Run the application with `docker run -it tea-shop-app .`
* Console Line:
  * What You'll Need: 
    * Java version 23 or higher
    * Maven
  * Instructions to Build & Run the Application:
    * Clone the repository using `git clone https://github.com/copelansam/TeaShop`
    * Navigate to the root directory of the repository
    * Build the application by running `mvn clean package`
    * Run the application with `java -jar target/tea-shop-1.0-SNAPSHOT.jar`
    * The program will open itself in your CLI where you can now play around with it