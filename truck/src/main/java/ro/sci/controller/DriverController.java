package ro.sci.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ro.sci.domain.Driver;
import ro.sci.service.DriverService;

import java.util.List;

@Controller
public class DriverController {
    @Autowired
    private DriverService driverService;

    @RequestMapping(value = "/drivers", method = RequestMethod.GET)
    public String listDrivers(Model model) {
        List<Driver> drivers = driverService.getAll();
        model.addAttribute("drivers", drivers);
        model.addAttribute("driver", new Driver());

        return "listDrivers";
    }

    @RequestMapping(value ="/drivers", method = RequestMethod.POST)
    public String createDrivers(Driver driver, Model model) {
        driverService.createDriver(driver);
        List<Driver> drivers = driverService.getAll();
        model.addAttribute("drivers", drivers);

        return "listDrivers";
    }

}
