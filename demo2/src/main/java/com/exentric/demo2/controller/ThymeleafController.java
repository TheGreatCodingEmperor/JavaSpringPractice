package com.exentric.demo2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.exentric.demo2.dto.Staff;

@Controller
public class ThymeleafController {
    @GetMapping("/index")
    public String GetIndex(Model model){
        Staff staff = new Staff();
		staff.setId(1);
		staff.setAccount("Json");
		staff.setName("stil Json");
		
		model.addAttribute("staff",staff);
        return "index";
    }
}
