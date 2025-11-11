package SoftCoders.ElectroBusRoute.model;

import java.util.Objects;

public class BusStop {
    private String id;
    private String name;
    private double latitude;
    private double longitude;

    public BusStop() {
    }

    public BusStop(String id, String name, double latitude, double longitude) {
        this.id = id;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BusStop busStop = (BusStop) o;
        return Double.compare(latitude, busStop.latitude) == 0 && Double.compare(longitude, busStop.longitude) == 0 && Objects.equals(id, busStop.id) && Objects.equals(name, busStop.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, latitude, longitude);
    }

    @Override
    public String toString() {
        return "BusStop{" +
               "id='" + id + "'" +
               ", name='" + name + "'" +
               '}';
    }
}
