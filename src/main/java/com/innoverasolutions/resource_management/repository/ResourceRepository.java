package com.innoverasolutions.resource_management.repository;
import com.innoverasolutions.resource_management.model.Allocation;
import com.innoverasolutions.resource_management.model.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResourceRepository extends JpaRepository<Resource,Long>{

        }