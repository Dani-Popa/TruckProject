package ro.sci.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ro.sci.DAO.DriverDAO;
import ro.sci.domain.Driver;

import java.util.List;

@Service
public class DriverServiceImpl implements DriverService {

    @Qualifier("driverDao")
    @Autowired
    private DriverDAO driverDao;

    @Override
    public List<Driver> getAll() {
        return driverDao.getAll();
    }

    @Override
    public void createDriver(Driver driver) {
        driverDao.create(driver);

    }


}
