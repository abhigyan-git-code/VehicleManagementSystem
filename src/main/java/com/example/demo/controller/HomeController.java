package com.example.demo.controller;

import com.example.demo.entity.Vehicle;
import com.example.demo.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @Autowired
    private VehicleService vehicleService;

    // Home Page
    @GetMapping("/")
    public String home(Model model) {

        model.addAttribute("vehicles",
                vehicleService.getAllVehicles());

        return "index";
    }

    // Open Add Vehicle Page
    @GetMapping("/addVehicle")
    public String addVehiclePage(Model model) {

        model.addAttribute("vehicle",
                new Vehicle());

        return "addVehicle";
    }

    // Save Vehicle
    @PostMapping("/saveVehicle")
    public String saveVehicle(@ModelAttribute Vehicle vehicle) {

        vehicleService.saveVehicle(vehicle);

        return "redirect:/";
    }

    // Edit Vehicle
    @GetMapping("/edit/{id}")
    public String editVehicle(@PathVariable Long id,
                              Model model) {

        Vehicle vehicle =
                vehicleService.getVehicleById(id);

        model.addAttribute("vehicle", vehicle);

        return "updateVehicle";
    }

    // Update Vehicle
    @PostMapping("/updateVehicle")
    public String updateVehicle(@ModelAttribute Vehicle vehicle) {

        vehicleService.updateVehicle(vehicle.getId(),
                vehicle);

        return "redirect:/";
    }

    // Delete Vehicle
    @GetMapping("/delete/{id}")
    public String deleteVehicle(@PathVariable Long id) {

        vehicleService.deleteVehicle(id);

        return "redirect:/";
    }

}