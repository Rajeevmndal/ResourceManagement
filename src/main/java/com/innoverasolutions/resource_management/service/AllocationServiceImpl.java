package com.innoverasolutions.resource_management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.innoverasolutions.resource_management.model.Allocation;
import com.innoverasolutions.resource_management.repository.AllocationRepository;

import java.util.List;

@Service
public class AllocationServiceImpl implements AllocationService {

    @Autowired
    private AllocationRepository allocationRepository;

    @Override
    public List<Allocation> getAllAllocations() {
        return allocationRepository.findAll();
    }

    @Override
    public Allocation saveAllocation(Allocation allocation) {
        return allocationRepository.save(allocation);
    }

    @Override
    public void deleteAllocation(Long id) {
        allocationRepository.deleteById(id);
    }
}

