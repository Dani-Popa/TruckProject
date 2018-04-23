package ro.sci.service;

import ro.sci.domain.Driver;
import ro.sci.domain.Truck;

import java.util.List;

public interface DriverService {

    List<Driver> getAll();

    void createDriver(Driver driver);
}
