package SoftCoders.ElectroBusRoute.controller;

import SoftCoders.ElectroBusRoute.model.BusRoute;
import SoftCoders.ElectroBusRoute.model.BusStop;
import SoftCoders.ElectroBusRoute.service.GraphService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RouteController {

    @Autowired
    private GraphService graphService;

    @GetMapping("/shortest-path")
    public List<BusStop> getShortestPath(@RequestParam String startStopId, @RequestParam String endStopId) {
        return graphService.findShortestPath(startStopId, endStopId);
    }

    @GetMapping("/stops")
    public List<BusStop> getAllStops() {
        return graphService.getAllStops();
    }

    @GetMapping("/routes")
    public Collection<BusRoute> getAllRoutes() {
        return graphService.getAllRoutes();
    }
}
