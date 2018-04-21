package ro.sci.domain;

public class Route {

    private String start;
    private String destination;

    public Route(String start, String destination) {
        this.start = start;
        this.destination = destination;
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

    public void setDestination(String end) {
        this.destination = end;
    }
}