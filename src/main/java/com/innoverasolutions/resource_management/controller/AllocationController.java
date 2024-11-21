package com.innoverasolutions.resource_management.controller;

import com.innoverasolutions.resource_management.model.Allocation;
import com.innoverasolutions.resource_management.model.Project;
import com.innoverasolutions.resource_management.model.Resource;
import com.innoverasolutions.resource_management.service.AllocationService;
import com.innoverasolutions.resource_management.service.ProjectService;
import com.innoverasolutions.resource_management.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/allocations")
public class AllocationController {

    @Autowired
    private AllocationService allocationService;

    @Autowired
    private ResourceService resourceService;

    @Autowired
    private ProjectService projectService;

    // View all allocations
    @GetMapping
    public String getAllAllocations(Model model) {
        model.addAttribute("allocations", allocationService.getAllAllocations());
        return "allocations"; // Name of the template for displaying all allocations
    }

    // Show form to create a new allocation
    @GetMapping("/new")
    public String showCreateAllocationForm(Model model) {
        List<Resource> resources = resourceService.getAllResources(); // Fetch resources
        List<Project> projects = projectService.findAllProjects(); // Fetch projects

        model.addAttribute("allocation", new Allocation()); // New allocation object for binding
        model.addAttribute("resources", resources); // Add resources to the model
        model.addAttribute("projects", projects); // Add projects to the model

        return "allocationForm"; // Name of the template for the form
    }

    // Save the new allocation
    // Save the new allocation
    @PostMapping
    public String saveAllocation(@ModelAttribute("allocation") Allocation allocation, Model model) {
        // Check if the resource is already allocated to a project
        if (resourceService.isResourceAllocated(allocation.getResource().getId())) {
            model.addAttribute("error", "This resource is already allocated to another project.");
            // Add the allocation object back to the model so form fields retain the input values
            model.addAttribute("allocation", allocation);

            // You may need to re-fetch the resources and projects as well in case they are needed for re-selection
            model.addAttribute("resources", resourceService.getAllResources());
            model.addAttribute("projects", projectService.findAllProjects());

            return "allocationForm"; // Return to the form with an error message and previously entered data
        }

        // If not allocated, save the allocation
        allocationService.saveAllocation(allocation);
        return "redirect:/allocations"; // Redirect to the list of allocations after saving
    }


    // Delete an allocation by ID
    @GetMapping("/delete/{id}")
    public String deleteAllocation(@PathVariable Long id) {
        allocationService.deleteAllocation(id);
        return "redirect:/allocations"; // Redirect to the list of allocations
    }

}

