# Kaizen Review for Week 3 Assignment

## What was built:
Implemented a `BusService` class in the Spring Boot application demonstrating basic data structure operations:
1.  **Bus Stop Management:** Add, delete, and find `BusStop` objects by ID using a `HashMap`.
2.  **Bus Route Simulation:** Simulated a bus moving through a list of stops using a `Queue` (`LinkedList`).
3.  **Bus Stop Search:** Efficiently search for bus stops by name using the `HashMap` values and stream filtering.
These features were integrated into the `main` method of `ElectroBusRouteApplication.java` for demonstration purposes.

## Problem or limitation found:
*   The current implementation is a "dummy project" and lacks persistence (data is lost on application restart).
*   No robust error handling or user input validation in the `BusService` methods.
*   The demonstration is limited to console output and not integrated with web controllers or a front-end.
*   The `BusService` directly prints to console, which is not ideal for a production-grade service layer.

## Improvement idea:
*   Integrate a database (e.g., H2, MySQL) for data persistence using Spring Data JPA.
*   Implement proper exception handling and validation for service operations.
*   Develop REST endpoints in a controller to expose `BusService` functionalities via a web API.
*   Replace console output with a logging framework (e.g., SLF4J with Logback) for better monitoring.
*   Create dedicated unit and integration tests for `BusService` instead of in the main application.
