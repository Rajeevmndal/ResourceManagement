package com.innoverasolutions.resource_management.controller;

import com.innoverasolutions.resource_management.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/reports")
    public String viewReports(Model model) {
        model.addAttribute("resources", reportService.generateResourceReport());
        return "reports"; // This should match your HTML file name without the extension.
       }
}