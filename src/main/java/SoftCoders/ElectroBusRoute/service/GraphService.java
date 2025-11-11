package SoftCoders.ElectroBusRoute.service;

import SoftCoders.ElectroBusRoute.model.BusRoute;
import SoftCoders.ElectroBusRoute.model.BusStop;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GraphService {

    private Map<BusStop, List<BusRoute>> adjStops;
    private List<BusStop> allStops;

    public GraphService() {
        adjStops = new HashMap<>();
        allStops = new ArrayList<>();
        initializeGraph();
    }

    private void addStop(BusStop stop) {
        adjStops.putIfAbsent(stop, new ArrayList<>());
        allStops.add(stop);
    }

    private void addRoute(BusStop from, BusStop to, double distance, double duration) {
        BusRoute route = new BusRoute(from.getId() + "-" + to.getId(), from, to, distance, duration);
        adjStops.get(from).add(route);
    }

    private void initializeGraph() {
        // Define Bus Stops for Sahiwal
        BusStop stopA = new BusStop("A", "COMSATS University", 30.641618768618915, 73.14935191355603);
        BusStop stopB = new BusStop("B", "Sahiwal Medical College", 30.6780, 73.0819);
        BusStop stopC = new BusStop("C", "District Headquarters Hospital", 30.6778, 73.1065);
        BusStop stopD = new BusStop("D", "Railway Station", 30.6707, 73.1109);
        BusStop stopE = new BusStop("E", "Farid Town", 30.6635, 73.1210);
        BusStop stopF = new BusStop("F", "Tariq Bin Ziad Colony", 30.6850, 73.1250);

        // Add stops to the graph
        addStop(stopA);
        addStop(stopB);
        addStop(stopC);
        addStop(stopD);
        addStop(stopE);
        addStop(stopF);

        // Define Routes (Edges) for Sahiwal
        addRoute(stopA, stopC, 2.5, 5); // COMSATS to DHQ
        addRoute(stopC, stopB, 2.0, 4); // DHQ to Medical College
        addRoute(stopC, stopD, 1.0, 3); // DHQ to Railway Station
        addRoute(stopD, stopE, 1.5, 4); // Railway Station to Farid Town
        addRoute(stopE, stopF, 2.2, 5); // Farid Town to Tariq Bin Ziad
        addRoute(stopB, stopF, 3.0, 7); // Medical College to Tariq Bin Ziad

        // Add reverse routes for undirected graph (or if routes are bidirectional)
        addRoute(stopC, stopA, 2.5, 5);
        addRoute(stopB, stopC, 2.0, 4);
        addRoute(stopD, stopC, 1.0, 3);
        addRoute(stopE, stopD, 1.5, 4);
        addRoute(stopF, stopE, 2.2, 5);
        addRoute(stopF, stopB, 3.0, 7);
    }

    public List<BusStop> getAllStops() {
        return allStops;
    }

    public Collection<BusRoute> getAllRoutes() {
        Set<BusRoute> routes = new HashSet<>();
        for (List<BusRoute> routeList : adjStops.values()) {
            routes.addAll(routeList);
        }
        return routes;
    }

    /**
     * Finds the shortest path between two bus stops using Dijkstra's algorithm.
     *
     * @param startStopId The ID of the starting bus stop.
     * @param endStopId   The ID of the ending bus stop.
     * @return A list of BusStop objects representing the shortest path, or an empty list if no path is found.
     */
    public List<BusStop> findShortestPath(String startStopId, String endStopId) {
        BusStop startStop = getStopById(startStopId);
        BusStop endStop = getStopById(endStopId);

        if (startStop == null || endStop == null) {
            return Collections.emptyList();
        }

        Map<BusStop, Double> distances = new HashMap<>();
        Map<BusStop, BusStop> predecessors = new HashMap<>();
        PriorityQueue<BusStop> pq = new PriorityQueue<>(Comparator.comparingDouble(distances::get));

        // Initialize distances
        for (BusStop stop : allStops) {
            distances.put(stop, Double.MAX_VALUE);
        }
        distances.put(startStop, 0.0);
        pq.add(startStop);

        while (!pq.isEmpty()) {
            BusStop current = pq.poll();

            if (current.equals(endStop)) {
                break; // Found the shortest path to the end stop
            }

            for (BusRoute route : adjStops.getOrDefault(current, Collections.emptyList())) {
                BusStop neighbor = route.getToStop();
                double newDist = distances.get(current) + route.getDistance(); // Using distance as weight

                if (newDist < distances.get(neighbor)) {
                    distances.put(neighbor, newDist);
                    predecessors.put(neighbor, current);
                    pq.add(neighbor);
                }
            }
        }

        return reconstructPath(predecessors, startStop, endStop);
    }

    private BusStop getStopById(String id) {
        return allStops.stream()
                .filter(stop -> stop.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    private List<BusStop> reconstructPath(Map<BusStop, BusStop> predecessors, BusStop startStop, BusStop endStop) {
        List<BusStop> path = new LinkedList<>();
        BusStop current = endStop;

        // Reconstruct path backwards from endStop to startStop
        while (current != null && !current.equals(startStop)) {
            path.add(0, current);
            current = predecessors.get(current);
        }

        // If current is null, it means startStop was not reachable from endStop (no path)
        // Or if current is not equal to startStop, it means path is incomplete
        if (current == null || !current.equals(startStop)) {
            return Collections.emptyList(); // No path found
        }

        path.add(0, startStop); // Add the start stop to the beginning of the path
        return path;
    }
}
