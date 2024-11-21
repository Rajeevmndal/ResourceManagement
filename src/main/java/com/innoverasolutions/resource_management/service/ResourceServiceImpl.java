package com.innoverasolutions.resource_management.service;

import com.innoverasolutions.resource_management.model.Allocation;
import com.innoverasolutions.resource_management.model.Resource;
import com.innoverasolutions.resource_management.repository.AllocationRepository;
import com.innoverasolutions.resource_management.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceRepository resourceRepository;

    @Autowired
    private AllocationRepository allocationRepository;

    @Override
    public void saveResource(Resource resource) {
        resourceRepository.save(resource);
    }

    @Override
    public Iterable<Resource> findResources() {
        return resourceRepository.findAll();
    }

    @Override
    public Resource getResourceId(Long id) {
        return resourceRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteResource(Long id) {
        resourceRepository.deleteById(id);
    }

    @Override
    public List<Resource> getAllResources() {
        return resourceRepository.findAll();
    }

    @Override
    public boolean isResourceAllocated(Long resourceId) {
        if (resourceId == null) {
            return false;  // Invalid resource ID
        }
        // Check if there are any allocations for this resource
        List<Allocation> allocations = allocationRepository.findByResourceId(resourceId);
        return !allocations.isEmpty();  // Return true if there are any allocations
    }
}
