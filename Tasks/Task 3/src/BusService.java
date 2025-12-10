import java.util.*;
import java.util.stream.Collectors;

/**
 * A simplified service for managing bus stops and simulating bus routes
 * using basic data structures. This is a dummy implementation for
 * demonstration purposes, focusing on core data structure operations.
 */
public class BusService {

    // Using HashMap for efficient lookup, add, and delete operations by ID
    private Map<String, BusStop> busStopsMap = new HashMap<>();

    // --- Feature 1: Add, Delete, Search (by ID) Bus Stops ---

    /**
     * Adds a new bus stop to the service.
     * @param busStop The BusStop object to add.
     * @return true if the bus stop was added, false if a stop with the same ID already exists.
     */
    public boolean addBusStop(BusStop busStop) {
        if (busStopsMap.containsKey(busStop.getId())) {
            return false; // Bus stop with this ID already exists
        }
        busStopsMap.put(busStop.getId(), busStop);
        System.out.println("Added Bus Stop: " + busStop);
        return true;
    }

    /**
     * Deletes a bus stop by its ID.
     * @param id The ID of the bus stop to delete.
     * @return The removed BusStop object, or null if not found.
     */
    public BusStop deleteBusStop(String id) {
        BusStop removedStop = busStopsMap.remove(id);
        if (removedStop != null) {
            System.out.println("Removed Bus Stop: " + removedStop);
        } else {
            System.out.println("Bus Stop with ID " + id + " not found for deletion.");
        }
        return removedStop;
    }

    /**
     * Finds a bus stop by its ID.
     * @param id The ID of the bus stop to find.
     * @return The BusStop object if found, otherwise null.
     */
    public BusStop findBusStopById(String id) {
        System.out.println("Searching for Bus Stop by ID: " + id);
        return busStopsMap.get(id);
    }

    // --- Feature 2: Simulate Bus Route using a Queue ---

    /**
     * Simulates a bus moving along a route, processing stops in order.
     * Uses a Queue to manage the sequence of stops.
     * @param routeStops A list of bus stops that define the route.
     */
    public void simulateBusRoute(List<BusStop> routeStops) {
        if (routeStops == null || routeStops.isEmpty()) {
            System.out.println("No stops provided for route simulation.");
            return;
        }

        Queue<BusStop> busRouteQueue = new LinkedList<>(routeStops);
        System.out.println("\n--- Simulating Bus Route ---");
        System.out.println("Route: " + routeStops.stream().map(BusStop::getName).collect(Collectors.joining(" -> ")));

        while (!busRouteQueue.isEmpty()) {
            BusStop currentStop = busRouteQueue.poll(); // Get and remove the head of the queue
            System.out.println("Bus arrived at: " + currentStop.getName() + " (ID: " + currentStop.getId() + ")");
            // Simulate some activity at the stop
            try {
                Thread.sleep(500); // Wait for 0.5 seconds
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Bus route simulation interrupted.");
            }
        }
        System.out.println("--- Bus Route Simulation Finished ---");
    }

    // --- Feature 3: Search Bus Stops by Name (Efficiently) ---

    /**
     * Finds bus stops whose names contain the given search term (case-insensitive).
     * Uses the internal map for efficient access to all stops.
     * @param nameQuery The partial or full name to search for.
     * @return A list of matching BusStop objects.
     */
    public List<BusStop> searchBusStopsByName(String nameQuery) {
        if (nameQuery == null || nameQuery.trim().isEmpty()) {
            return Collections.emptyList();
        }
        String lowerCaseQuery = nameQuery.toLowerCase();
        System.out.println("\nSearching for Bus Stops containing name: '" + nameQuery + "'");
        return busStopsMap.values().stream()
                .filter(stop -> stop.getName().toLowerCase().contains(lowerCaseQuery))
                .collect(Collectors.toList());
    }

    /**
     * Returns an unmodifiable list of all currently managed bus stops.
     * @return A list of all BusStop objects.
     */
    public List<BusStop> getAllBusStops() {
        return new ArrayList<>(busStopsMap.values());
    }
}
