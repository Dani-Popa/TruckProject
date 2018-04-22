package ro.sci.domain;

public class Truck {

    private String producer;
    private String model;
    private int truckid;


    public Truck() {
    }

    public Truck(String producer, String model, int truckid) {
        this.producer = producer;
        this.model = model;
        this.truckid = truckid;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getTruckid() {
        return truckid;
    }

    public void setTruckid(int truckid) {
        this.truckid = truckid;
    }
}
