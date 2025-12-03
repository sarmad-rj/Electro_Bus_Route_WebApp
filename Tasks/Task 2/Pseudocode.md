# Pseudocode

## 1. Function: `authenticateUser(username, password)`

```pseudocode
FUNCTION authenticateUser(username, password):
  // Retrieve user details from a data store (e.g., database, hash map)
  user = DATABASE.getUserByUsername(username)

  IF user IS NOT NULL THEN
    // Hash the provided password and compare with stored hashed password
    hashedPassword = HASH(password)
    IF hashedPassword == user.getHashedPassword() THEN
      // Check if user account is active or enabled
      IF user.isActive() THEN
        RETURN TRUE // Authentication successful
      ELSE
        LOG("User account " + username + " is inactive.")
        RETURN FALSE
      END IF
    ELSE
      LOG("Invalid password for user: " + username)
      RETURN FALSE // Incorrect password
    END IF
  ELSE
    LOG("User " + username + " not found.")
    RETURN FALSE // User not found
  END IF
END FUNCTION
```

## 2. Function: `addBusRoute(routeId, listOfStops)`

```pseudocode
FUNCTION addBusRoute(routeId, listOfStops):
  // Check if a route with the given ID already exists
  IF DATABASE.getRouteById(routeId) IS NOT NULL THEN
    LOG("Route with ID " + routeId + " already exists.")
    RETURN FALSE // Route already exists
  END IF

  // Validate that listOfStops is not empty and contains valid BusStop objects
  IF listOfStops IS EMPTY THEN
    LOG("Cannot add route: List of stops is empty.")
    RETURN FALSE
  END IF

  FOR EACH stop IN listOfStops:
    IF NOT DATABASE.isValidBusStop(stop.getStopId()) THEN
      LOG("Invalid bus stop ID " + stop.getStopId() + " in list for route " + routeId)
      RETURN FALSE // Contains invalid bus stop
    END IF
  END FOR

  // Create a new BusRoute object
  newRoute = CREATE BusRoute(routeId, listOfStops)

  // Store the new route in the data store
  DATABASE.saveBusRoute(newRoute)
  LOG("Bus route " + routeId + " added successfully.")
  RETURN TRUE
END FUNCTION
```

## 3. Function: `findShortestPath(startStopId, endStopId)`

```pseudocode
FUNCTION findShortestPath(startStopId, endStopId):
  // Initialize graph representation (Adjacency List)
  graph = GRAPH_SERVICE.buildGraphFromBusRoutes()

  // Check if start and end stops exist in the graph
  IF NOT graph.containsStop(startStopId) OR NOT graph.containsStop(endStopId) THEN
    LOG("Start or end stop ID not found in the bus network.")
    RETURN NULL // Or appropriate error/empty path
  END IF

  // Use a shortest path algorithm (e.g., Dijkstra's, A*)
  // Assume GRAPH_SERVICE.dijkstra returns a list of stop IDs forming the path
  path = GRAPH_SERVICE.dijkstra(graph, startStopId, endStopId)

  IF path IS NOT NULL AND path IS NOT EMPTY THEN
    LOG("Shortest path found from " + startStopId + " to " + endStopId)
    RETURN path // List of BusStop IDs
  ELSE
    LOG("No path found from " + startStopId + " to " + endStopId)
    RETURN NULL // No path exists
  END IF
END FUNCTION
```

## 4. Function: `getBusStopDetails(stopId)`

```pseudocode
FUNCTION getBusStopDetails(stopId):
  // Retrieve bus stop details from data store (e.g., database, hash map)
  busStop = DATABASE.getBusStopById(stopId)

  IF busStop IS NOT NULL THEN
    LOG("Retrieved details for bus stop ID: " + stopId)
    RETURN busStop // Return BusStop object
  ELSE
    LOG("Bus stop with ID " + stopId + " not found.")
    RETURN NULL // Bus stop not found
  END IF
END FUNCTION
```

## 5. Function: `getAllBusRoutes()`

```pseudocode
FUNCTION getAllBusRoutes():
  // Retrieve all bus routes from the data store
  allRoutes = DATABASE.getAllBusRoutes() // Returns a collection of BusRoute objects

  IF allRoutes IS NOT NULL AND NOT allRoutes IS EMPTY THEN
    LOG("Retrieved " + COUNT(allRoutes) + " bus routes.")
    RETURN allRoutes
  ELSE
    LOG("No bus routes found in the system.")
    RETURN EMPTY_LIST // Or appropriate empty collection
  END IF
END FUNCTION
