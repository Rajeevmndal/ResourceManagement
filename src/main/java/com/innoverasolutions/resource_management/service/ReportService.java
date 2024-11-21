package com.innoverasolutions.resource_management.service;

import com.innoverasolutions.resource_management.model.Resource;
import com.innoverasolutions.resource_management.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {

    @Autowired
    private ResourceRepository resourceRepository;

    public List<Resource> generateResourceReport() {
        return resourceRepository.findAll(); // Fetch all resources for the report
    }

    // Additional methods can be added for hackathon and user reports if needed.
}