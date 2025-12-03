# Operation Flow Explanation

## 1. User Login (Admin/Order Booker)

*   **What the operation does:** This operation allows an authenticated user (either an administrator or an order booker) to gain access to the system by verifying their provided username and password.
*   **Which Data Structure supports it:** A Hash Map (conceptually, likely implemented as a database table for persistence and scalability) supports this operation. The keys of the map would be usernames, and the values would be objects containing user-specific data, including a hashed password and role information.
*   **Why the Data Structure is suitable:** A Hash Map provides very efficient (average O(1) time complexity) lookup for user credentials. When a user attempts to log in, their username can be used as a key to quickly retrieve their stored information. This speed is crucial for a smooth and responsive login experience, especially in systems with many users.
*   **How the user interacts with it:** The user (admin or order booker) navigates to a login page (e.g., `adminlogin.html` or `orderbookerlogin.html`). They enter their username and password into respective input fields and submit the form. The system then processes these inputs to determine if the credentials are valid and grants or denies access accordingly.

## 2. Add Bus Route

*   **What the operation does:** This operation allows an authorized user (e.g., an administrator) to define and add a new bus route to the system. A bus route consists of an ordered sequence of bus stops.
*   **Which Data Structure supports it:** A List or Array of Bus Stop objects is used to represent a single bus route. Each `BusRoute` object itself might be stored in a Hash Map where the key is the `routeId` for quick retrieval.
*   **Why the Data Structure is suitable:** A List/Array is ideal for maintaining the specific order of bus stops along a route. This ensures that the sequence of stops is preserved exactly as intended, which is fundamental for navigation and scheduling. Using a Hash Map for `BusRoute` objects allows for quick access to a route's details using its unique identifier.
*   **How the user interacts with it:** An administrator accesses a route management interface. They might provide a route ID, a route name, and then sequentially select or input bus stops to add to the route. The order in which they add the stops dictates the route's path. After defining all stops, they would submit the information to save the new route.

## 3. Find Shortest Path

*   **What the operation does:** This operation calculates and returns the shortest sequence of bus stops (and implicitly, bus routes) required to travel between a specified starting bus stop and a destination bus stop.
*   **Which Data Structure supports it:** An Adjacency List is the primary data structure used to represent the bus network as a graph. Each bus stop is a node, and connections between stops (via bus routes) are edges.
*   **Why the Data Structure is suitable:** An Adjacency List is an efficient way to represent sparse graphs, which is common for transportation networks where each stop typically connects to only a few other stops. It allows for efficient traversal of the graph (e.g., when running Dijkstra's algorithm), as it only stores existing connections, reducing memory usage and speeding up neighbor lookups.
*   **How the user interacts with it:** A user (e.g., an order booker or a passenger using a public interface) would typically provide a starting bus stop ID and a destination bus stop ID. The system then processes this request, executes a shortest path algorithm on the underlying graph representation, and presents the user with the optimal path, possibly including estimated travel time or transfers.
