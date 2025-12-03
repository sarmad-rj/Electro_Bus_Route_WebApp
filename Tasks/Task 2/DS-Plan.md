# Data Structure Planning Table

| Operation                     | Data Structure Used         | Reason for Choosing the DS                                                                   |
| :---------------------------- | :-------------------------- | :------------------------------------------------------------------------------------------- |
| User Login (Admin/Order Booker) | Hash Map (conceptual, backed by database) | Efficient lookup of user credentials (username -> password hash, roles) for authentication.    |
| Add Bus Route                 | List/Array of Bus Stops     | Maintains the ordered sequence of bus stops that constitute a specific route.                 |
| Find Shortest Path            | Adjacency List (Graph)      | Represents the bus network as a graph, enabling efficient traversal for pathfinding algorithms like Dijkstra's. |
| Retrieve All Bus Stops        | Hash Map (Bus Stop ID -> Bus Stop Object) | Provides quick O(1) average time access to bus stop details by their unique ID and efficient iteration. |
| Update Bus Stop Information   | Hash Map (Bus Stop ID -> Bus Stop Object) | Allows direct and fast access (O(1) average time) to a specific bus stop record for modification. |
| Get all Bus Routes            | Hash Map (Route ID -> List of Bus Stops) | Provides quick access to specific bus routes and efficient iteration over all routes.          |
