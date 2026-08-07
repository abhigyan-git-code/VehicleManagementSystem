package com.example.demo.repository;

import com.example.demo.entity.ServiceRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<ServiceRecord, Long> {

}