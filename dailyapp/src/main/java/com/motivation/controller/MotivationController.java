package com.motivation.controller;

import com.motivation.model.Quote;
import com.motivation.model.MotivationalImage;
import com.motivation.service.MotivationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MotivationController {

    private final MotivationService motivationService;

    @Autowired
    public MotivationController(MotivationService motivationService) {
        this.motivationService = motivationService;
    }

    @GetMapping("/")
    public String home(Model model) {
        Quote dailyQuote = motivationService.getDailyQuote();
        MotivationalImage dailyImage = motivationService.getDailyImage();

        model.addAttribute("dailyQuote", dailyQuote);
        model.addAttribute("dailyImage", dailyImage);
        
        return "index";
    }
}