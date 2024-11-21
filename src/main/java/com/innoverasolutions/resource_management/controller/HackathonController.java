package com.innoverasolutions.resource_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.innoverasolutions.resource_management.model.Hackathon;
import com.innoverasolutions.resource_management.service.HackathonService;

@Controller
public class HackathonController {

    @Autowired
    private HackathonService hackathonService;

    @GetMapping("/hackathons")
    public String hackathons(Model model) {
        model.addAttribute("hackathons", hackathonService.findHackathons());
        return "hackathons"; // Ensure the template file name matches: hackathons.html
    }

    @GetMapping("/registerHackathon")
    public String registerHackathon(Model model) {
        Hackathon hackathon = new Hackathon();
        model.addAttribute("hackathon", hackathon);
        return "registerHackathon"; // Template: registerHackathon.html
    }

    @PostMapping("/saveHackathon")
    public String saveHackathon(@ModelAttribute("hackathon") Hackathon hackathon) {
        hackathonService.saveHackathon(hackathon);
        return "redirect:/hackathons"; // Redirect to the list of hackathons
    }

    @GetMapping("/updateHackathon/{id}")
    public String updateHackathon(Model model, @PathVariable Long id) {
        Hackathon hackathon = hackathonService.getHackathonId(id);
        model.addAttribute("hackathon", hackathon);
        return "updateFormHackathon"; // Template: updateFormHackathon.html
    }

    @GetMapping("/deleteHackathon/{id}")
    public String deleteHackathon(@PathVariable Long id) {
        hackathonService.deleteHackathon(id);
        return "redirect:/hackathons"; // Redirect to the list of hackathons
    }
}
