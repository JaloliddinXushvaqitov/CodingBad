package com.example.codingbad.Controller;

import com.example.codingbad.DTO.ApiResponse;
import com.example.codingbad.DTO.Royxatdan_otishDTO;
import com.example.codingbad.Service.Royxatdan_otishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Royxar")
public class Royxatcontroller {
    @Autowired
    Royxatdan_otishService royxatdan_otishService;

    @PostMapping("/royxatGet")
    public HttpEntity<?> royxat(@RequestBody Royxatdan_otishDTO royxatdan_otishDTO){
        ApiResponse apiResponse=royxatdan_otishService.qoshish(royxatdan_otishDTO);
        return ResponseEntity.status(apiResponse.isXolat()?200:208).body(apiResponse.getXabar());
    }
}
