package ro.sci.domain;

public class Route {

    private String start;
    private String destination;
    private float distance;
    private String status;
    private int id;

    public Route(String start, String destination, float distance, String status) {
        this.start = start;
        this.destination = destination;
        this.distance = distance;
        this.status = status;
    }

    public Route(){}

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}