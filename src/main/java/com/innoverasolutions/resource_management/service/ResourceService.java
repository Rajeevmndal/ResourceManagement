package com.innoverasolutions.resource_management.service;

import com.innoverasolutions.resource_management.model.Project;
import com.innoverasolutions.resource_management.model.Resource;

import java.util.List;

public interface ResourceService {
    void saveResource(Resource resource);
    Iterable<Resource> findResources();
    Resource getResourceId(Long id);
    void deleteResource(Long id);
    List<Resource> getAllResources();

    boolean isResourceAllocated(Long resourceId);
}
