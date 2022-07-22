package com.exentric.demo2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.exentric.demo2.dto.Staff;

@RestController
public class RestTemplateController {
    @GetMapping("/getToObject")
    public String getToObject() {
        RestTemplate restTemplate = new RestTemplate();
        Staff result = restTemplate.getForObject("https://mocki.io/v1/b04d9cc2-24b1-44aa-881f-e1cb8b66233c",
                Staff.class);
        System.out.println("Product id:" + result.getId());
        System.out.println("Product name:" + result.getName());
        // System.out.println("Product price:"+result.getPrice());
        return "getToObject success";
    }

}
