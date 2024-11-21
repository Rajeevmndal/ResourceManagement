package com.innoverasolutions.resource_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.innoverasolutions.resource_management.model.Allocation;

import java.util.List;

public interface AllocationRepository extends JpaRepository<Allocation, Long> {
    // Method to find allocations by resource ID
    List<Allocation> findByResourceId(Long resourceId);

    // Alternatively, you can create a method to check if a resource is allocated
    boolean existsByResourceId(Long resourceId);
}
