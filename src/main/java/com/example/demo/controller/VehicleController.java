package com.example.demo.controller;

import com.example.demo.entity.Vehicle;
import com.example.demo.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService service;

    // Create Vehicle
    @PostMapping
    public Vehicle save(@RequestBody Vehicle vehicle) {
        return service.saveVehicle(vehicle);
    }

    // Get All Vehicles
    @GetMapping
    public List<Vehicle> getAll() {
        return service.getAllVehicles();
    }

    // Get Vehicle By ID
    @GetMapping("/{id}")
    public Vehicle getById(@PathVariable Long id) {
        return service.getVehicleById(id);
    }

    // Update Vehicle
    @PutMapping("/{id}")
    public Vehicle update(@PathVariable Long id,
                          @RequestBody Vehicle vehicle) {
        return service.updateVehicle(id, vehicle);
    }

    // Delete Vehicle
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteVehicle(id);
        return "Vehicle Deleted Successfully";
    }
}