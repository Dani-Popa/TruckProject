package ro.sci.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ro.sci.DAO.TruckDAO;
import ro.sci.domain.Truck;

import java.util.List;

@Service
public class TruckServiceImpl implements TruckService {

    @Qualifier("truckDao")
    @Autowired
    private TruckDAO truckDao;

    @Override
    public List<Truck> getAll() {
        return truckDao.getAll();
    }


    @Override
    public void createTruck(Truck truck) {
        truckDao.create(truck);
    }

    @Override
    public void deleteTruckById(int id) {
        truckDao.deleteTruckById(id);
    }
}
