package ro.sci.service;

import ro.sci.domain.Truck;

import java.util.List;

public interface TruckService {

    List<Truck> getAll();

    void createTruck(Truck truck);

    void deleteTruckById(int id);
}
