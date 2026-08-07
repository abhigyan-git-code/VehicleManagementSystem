package com.example.demo.service;

import com.example.demo.entity.Vehicle;
import com.example.demo.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository repository;

    // Save Vehicle
    public Vehicle saveVehicle(Vehicle vehicle) {
        return repository.save(vehicle);
    }

    // Get All Vehicles
    public List<Vehicle> getAllVehicles() {
        return repository.findAll();
    }

    // Get Vehicle By ID
    public Vehicle getVehicleById(Long id) {
        return repository.findById(id).orElse(null);
    }

    // Update Vehicle
    public Vehicle updateVehicle(Long id, Vehicle vehicle) {

        Vehicle existingVehicle = repository.findById(id).orElse(null);

        if (existingVehicle != null) {
            existingVehicle.setOwnerName(vehicle.getOwnerName());
            existingVehicle.setVehicleNumber(vehicle.getVehicleNumber());
            existingVehicle.setBrand(vehicle.getBrand());
            existingVehicle.setModel(vehicle.getModel());

            return repository.save(existingVehicle);
        }

        return null;
    }

    // Delete Vehicle
    public void deleteVehicle(Long id) {
        repository.deleteById(id);
    }
}