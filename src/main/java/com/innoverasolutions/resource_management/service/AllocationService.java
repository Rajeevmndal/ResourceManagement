package com.innoverasolutions.resource_management.service;

import com.innoverasolutions.resource_management.model.Allocation;
import java.util.List;

public interface AllocationService {
    List<Allocation> getAllAllocations();
    Allocation saveAllocation(Allocation allocation);
    void deleteAllocation(Long id);
}
