package com.example.demo.service;

import com.example.demo.entity.ServiceRecord;
import com.example.demo.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceRecordService {

    @Autowired
    private ServiceRepository repository;

    // Save Service Record
    public ServiceRecord saveRecord(ServiceRecord record) {
        return repository.save(record);
    }

    // Get All Service Records
    public List<ServiceRecord> getAllRecords() {
        return repository.findAll();
    }

    // Get Service Record By ID
    public ServiceRecord getRecordById(Long id) {
        return repository.findById(id).orElse(null);
    }

    // Update Service Record
    public ServiceRecord updateRecord(Long id, ServiceRecord record) {

        ServiceRecord existing = repository.findById(id).orElse(null);

        if (existing != null) {
            existing.setServiceDate(record.getServiceDate());
            existing.setServiceType(record.getServiceType());
            existing.setCost(record.getCost());
            existing.setVehicle(record.getVehicle());

            return repository.save(existing);
        }

        return null;
    }

    // Delete Service Record
    public void deleteRecord(Long id) {
        repository.deleteById(id);
    }
}