package com.practica2.controller;

import com.practica2.domain.Hotel;
import com.practica2.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HotelController {
    @Autowired
    private HotelService hotelService;
    
    @GetMapping("/")
    private String listado(Model model) {
        var hoteles = hotelService.getHoteles();
        model.addAttribute("hoteles", hoteles);
        return "/index";
    }

}
