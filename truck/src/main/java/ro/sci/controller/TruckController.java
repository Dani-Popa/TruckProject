package ro.sci.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.sci.domain.Truck;
import ro.sci.service.TruckService;

import java.util.List;

@Controller
public class TruckController {
    @Autowired
    private TruckService truckService;

    @RequestMapping(value = "/trucks", method = RequestMethod.GET)
    public String listTrucks(Model model) {
        List<Truck> trucks = truckService.getAll();
        model.addAttribute("trucks", trucks);
        model.addAttribute("truck", new Truck());

        return "listTrucks";
    }

    @RequestMapping(value ="/trucks", method = RequestMethod.POST)
    public String createTruck(Truck truck, Model model) {
        truckService.createTruck(truck);
        List<Truck> trucks = truckService.getAll();
        model.addAttribute("trucks", trucks);

        return "listTrucks";
    }
}
