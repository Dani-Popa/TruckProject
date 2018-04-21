package ro.sci.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ro.sci.domain.Route;
import ro.sci.service.RouteService;

import java.util.List;

@Controller
public class RouteController {
    @Autowired
    private RouteService routeService;

    @RequestMapping(value = "/routes", method = RequestMethod.GET)
    public String listRoutes(Model model) {
        List<Route> routes = routeService.getAll();
        model.addAttribute("routes", routes);
        model.addAttribute("route", new Route());

        return "listRoutes";
    }

    @RequestMapping(value ="/routes", method = RequestMethod.POST)
    public String createRoute(Route route, Model model) {
        routeService.createRoute(route);
        List<Route> routes = routeService.getAll();
        model.addAttribute("routes", routes);

        return "listRoutes";
    }

}
