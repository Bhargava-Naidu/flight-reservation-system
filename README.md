Flight Reservation and Check-In System

Overview

This project is a Flight Reservation and Check-In System, consisting of two main components:

Flight Reservation System - A Spring Boot application that manages flight bookings and stores data in a MySQL database.

Flight Check-In System - A RESTful client that allows passengers to check in for their flights.

Technologies Used

Backend: Spring Boot, Spring MVC, Hibernate

Database: MySQL

Frontend: Thymeleaf (for Reservation UI)

API Communication: RESTful services

Build Tool: Maven

Version Control: Git & GitHub

Features

Flight Reservation System

User can search for flights.

User can book a flight and receive a ticket.

Admin can manage flight details (CRUD operations).

Data is stored in a MySQL database using Hibernate.

Flight Check-In System

Passengers can check in online using their reservation ID.

The system updates the reservation status upon check-in.

Communicates with the reservation system via REST APIs.

Installation & Setup

Prerequisites

Install Java (JDK 17+ recommended)

Install MySQL Server

Install Maven

Install IntelliJ IDEA or any IDE

Git installed on your system

Steps to Run

Clone the Repository

git clone https://github.com/Bhargava-Naidu/flight-reservation-system.git
cd flight-reservation-system

Configure the Database

Create a MySQL database named flight_db.

Update application.properties in src/main/resources/ with your database credentials:

spring.datasource.url=jdbc:mysql://localhost:3306/flight_db
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update

Build and Run the Application

mvn clean install
mvn spring-boot:run

Access the Application

Reservation System: http://localhost:8080

Check-In API: http://localhost:8081/checkin
