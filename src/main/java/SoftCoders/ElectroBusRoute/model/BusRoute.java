package SoftCoders.ElectroBusRoute.model;

import java.util.Objects;

public class BusRoute {
    private String id;
    private BusStop fromStop;
    private BusStop toStop;
    private double distance; // in kilometers
    private double duration; // in minutes

    public BusRoute() {
    }

    public BusRoute(String id, BusStop fromStop, BusStop toStop, double distance, double duration) {
        this.id = id;
        this.fromStop = fromStop;
        this.toStop = toStop;
        this.distance = distance;
        this.duration = duration;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BusStop getFromStop() {
        return fromStop;
    }

    public void setFromStop(BusStop fromStop) {
        this.fromStop = fromStop;
    }

    public BusStop getToStop() {
        return toStop;
    }

    public void setToStop(BusStop toStop) {
        this.toStop = toStop;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BusRoute busRoute = (BusRoute) o;
        return Double.compare(distance, busRoute.distance) == 0 && Double.compare(duration, busRoute.duration) == 0 && Objects.equals(id, busRoute.id) && Objects.equals(fromStop, busRoute.fromStop) && Objects.equals(toStop, busRoute.toStop);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fromStop, toStop, distance, duration);
    }

    @Override
    public String toString() {
        return "BusRoute{"
               + "id='" + id + "'"
               + ", fromStop=" + fromStop.getName() + ""
               + ", toStop=" + toStop.getName() + ""
               + ", distance=" + distance + ""
               + ", duration=" + duration + ""
               + "}";
    }
}
