package ro.sci.service;

import ro.sci.domain.Route;

import java.util.List;

public interface RouteService {

    List<Route> getAll();

    void createRoute(Route route);

}
