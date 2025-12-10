//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] var0) {
        System.out.println("--- Starting Bus Service Demonstration ---");
        BusService var1 = new BusService();
        System.out.println("\n--- Testing: Normal Inputs ---");
        System.out.println("Normal Input: Adding unique bus stops.");
        BusStop var2 = new BusStop("S001", "Central Station", 34.0522, -118.2437);
        BusStop var3 = new BusStop("S002", "Downtown Plaza", 34.045, -118.255);
        BusStop var4 = new BusStop("S003", "Market Square", 34.06, -118.23);
        BusStop var5 = new BusStop("S004", "Riverside Park", 34.07, -118.22);
        var1.addBusStop(var2);
        var1.addBusStop(var3);
        var1.addBusStop(var4);
        var1.addBusStop(var5);
        System.out.println("\nNormal Input: Finding an existing bus stop (S002).");
        System.out.println("Result: " + var1.findBusStopById("S002"));
        System.out.println("\nNormal Input: Searching for bus stops by a name that exists ('Market').");
        List var6 = var1.searchBusStopsByName("Market");
        System.out.println("Result: " + var6);
        System.out.println("\nNormal Input: Simulating a valid bus route.");
        List var7 = Arrays.asList(var2, var3, var4, var5);
        var1.simulateBusRoute(var7);
        System.out.println("\n--- Testing: Incorrect Inputs & Edge Cases ---");
        System.out.println("Incorrect Input: Attempting to add a bus stop with a duplicate ID (S001).");
        boolean var8 = var1.addBusStop(new BusStop("S001", "Duplicate Stop", (double)0.0F, (double)0.0F));
        System.out.println("Result: Bus stop added? " + var8 + " (should be false)");
        System.out.println("\nEdge Case: Searching for a non-existent bus stop ID (S005).");
        BusStop var9 = var1.findBusStopById("S005");
        System.out.println("Result: " + var9 + " (should be null)");
        System.out.println("\nEdge Case: Searching for a bus stop with a null name query.");
        List var10 = var1.searchBusStopsByName((String)null);
        System.out.println("Result: " + var10 + " (should be an empty list)");
        System.out.println("\nNormal Input: Deleting an existing bus stop (S002).");
        var1.deleteBusStop("S002");
        System.out.println("\nEdge Case: Trying to find the bus stop immediately after deletion (S002).");
        BusStop var11 = var1.findBusStopById("S002");
        System.out.println("Result: " + var11 + " (should be null)");
        System.out.println("\n--- Bus Service Demonstration Complete ---");
    }
}
