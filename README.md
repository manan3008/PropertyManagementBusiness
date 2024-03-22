# Property Management System - Persistence Tier

## Overview

This project focuses on developing the persistence tier of an e-business system for a property management company. It is implemented using Java EE technology and leverages the Java Persistence API (JPA) to manage interactions with a MySQL database. The system handles properties that are for sale, for rent, and in-rent, applying principles of inheritance and relationships to efficiently model data.

## Key Features

- Management of three types of properties: For Sale, For Rent, In-Rent.
- Persistence and retrieval of property and property manager information using JPA.
- One-to-many unidirectional relationship between property managers and properties.

## Technology Stack

- Java EE
- Java Persistence API (JPA)
- MySQL Database

## Project Structure

- Entity classes modeling properties and property managers.
- Repository classes for data access.
- `Main.java` for demonstrating persistence and retrieval functionalities.

## Testing Instructions

The system includes a basic user interface to demonstrate the persistence and retrieval of property and property manager information. Follow these steps to test the application:

1. **Persisting Entities**:
   - Upon running `Main.java`, the system will automatically persist sample entities into the database, including 2 sale properties, 1 rent property, 1 in-rent property, and 2 property managers with their allocations.

2. **Retrieving Entities**:
   - The application provides options to retrieve details of a specific property, a property manager, and his/her allocations from the database.
   - Follow the on-screen instructions to input your choices and view the retrieved data.

## Entity and Relationship Overview

- **Entities**: The system defines four Java classes to model the properties and property managers. A superclass `Property` is used to abstract common attributes, while subclasses `SaleProperty`, `RentProperty`, and `InRentProperty` represent specific types of properties.
- **Relationships**: A one-to-many unidirectional relationship is established between `PropertyManager` and `Property` entities to represent the management allocations.

## Custom Queries

The application utilizes the Java Persistence Query Language (JPQL) for retrieving data. Examples of these queries are documented in the `PropertyRepository` and `PropertyManagerRepository` classes.
