package ro.sci.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ro.sci.DAO.RouteDAO;
import ro.sci.domain.Route;

import java.util.List;

@Service
public class RouteServiceImpl implements RouteService {

    @Qualifier("routeDao")
    @Autowired
    private RouteDAO routeDao;

    @Override
    public List<Route> getAll() {
        return routeDao.getAll();
    }

    @Override
    public void createRoute(Route route) {
        routeDao.create(route);

    }
}
