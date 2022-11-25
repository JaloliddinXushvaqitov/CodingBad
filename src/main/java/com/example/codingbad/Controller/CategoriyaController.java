package com.example.codingbad.Controller;

import com.example.codingbad.DTO.ApiResponse;
import com.example.codingbad.DTO.CategoriyaDto;
import com.example.codingbad.DTO.Royxatdan_otishDTO;
import com.example.codingbad.Service.CategoriyaService;
import com.example.codingbad.Service.Royxatdan_otishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Categoriya")
public class CategoriyaController {
    @Autowired
    CategoriyaService categoriyaService;

    @PostMapping("/Joylashcategoriya")
    public HttpEntity<?> joylash(@RequestBody CategoriyaDto categoriyaDto){
        ApiResponse apiResponse=categoriyaService.joylash(categoriyaDto);
        return ResponseEntity.status(apiResponse.isXolat()?200:208).body(apiResponse.getXabar());
    }
    @PutMapping("/Taxrirlashcategoriya/{id}")
    public HttpEntity<?>taxrirlash(@PathVariable Integer id, @RequestBody CategoriyaDto categoriyaDto){
        ApiResponse apiResponse=categoriyaService.taxrirlashid(id,categoriyaDto);
        return ResponseEntity.status(apiResponse.isXolat()?200:208).body(apiResponse.getXabar());
    }
    @GetMapping("/oqish")
    public HttpEntity<?> oqish(){
        ApiResponse apiResponse=categoriyaService.oqish();
        return ResponseEntity.status(apiResponse.isXolat()?200:208).body(apiResponse.getXabar());
    }
    @GetMapping("/oqishid/{id}")
    public HttpEntity<?>Oqishid(@PathVariable Integer id){
        ApiResponse apiResponse=categoriyaService.oqishid(id);
        return ResponseEntity.status(apiResponse.isXolat()?200:208).body(apiResponse.getXabar());
    }
    @DeleteMapping("/deleteid/{id}")
    public HttpEntity<?>deleteid(@PathVariable Integer id){
        ApiResponse apiResponse=categoriyaService.deleteid(id);
        return ResponseEntity.status(apiResponse.isXolat()?200:208).body(apiResponse.getXabar());
    }
}
