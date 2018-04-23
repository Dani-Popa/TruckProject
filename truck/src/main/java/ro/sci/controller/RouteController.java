package ro.sci.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ro.sci.domain.Route;
import ro.sci.service.RouteService;

import java.util.List;

@Controller
@RequestMapping("/routes")
public class RouteController {
    @Autowired
    private RouteService routeService;

    @RequestMapping(method = RequestMethod.GET)
    public String listRoutes(Model model) {
        List<Route> routes = routeService.getAll();
        model.addAttribute("routes", routes);
        model.addAttribute("route", new Route());

        return "listRoutes";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String createRoute(Route route, Model model) {
        routeService.createRoute(route);
        List<Route> routes = routeService.getAll();
        model.addAttribute("routes", routes);

        return "listRoutes";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public String deleteRouteById(@PathVariable int id) {
        routeService.deleteRouteById(id);

        return "redirect:/routes";
    }

}
