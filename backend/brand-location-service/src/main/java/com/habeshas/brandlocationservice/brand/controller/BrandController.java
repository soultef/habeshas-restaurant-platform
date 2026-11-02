package com.habeshas.brandlocationservice.brand.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/brands")
public class BrandController {

    @GetMapping
    public String getBrands() {
        return "Brands";
    }
}
