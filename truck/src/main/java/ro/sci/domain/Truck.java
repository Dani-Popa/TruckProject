package ro.sci.domain;

public class Truck {

   private String producer;
   private int truckid;

    public Truck() {
    }

    public Truck(String producer, int truckid) {
        this.producer = producer;
        this.truckid = truckid;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public int getTruckid() {
        return truckid;
    }

    public void setTruckid(int truckid) {
        this.truckid = truckid;
    }
}
