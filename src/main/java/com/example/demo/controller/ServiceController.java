package com.example.demo.controller;

import com.example.demo.entity.ServiceRecord;
import com.example.demo.service.ServiceRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/services")
public class ServiceController {

    @Autowired
    private ServiceRecordService service;

    // Save Service Record
    @PostMapping
    public ServiceRecord save(@RequestBody ServiceRecord record) {
        return service.saveRecord(record);
    }

    // Get All Service Records
    @GetMapping
    public List<ServiceRecord> getAll() {
        return service.getAllRecords();
    }

    // Get Service Record By ID
    @GetMapping("/{id}")
    public ServiceRecord getById(@PathVariable Long id) {
        return service.getRecordById(id);
    }

    // Update Service Record
    @PutMapping("/{id}")
    public ServiceRecord update(@PathVariable Long id,
                                @RequestBody ServiceRecord record) {
        return service.updateRecord(id, record);
    }

    // Delete Service Record
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteRecord(id);
        return "Service Record Deleted Successfully";
    }
}