package com.example.codingbad.Controller;

import com.example.codingbad.DTO.ApiResponse;
import com.example.codingbad.DTO.NamunaDTO;
import com.example.codingbad.Service.NamunaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/namuna")
public class NamunaController {
    @Autowired
    NamunaService namunaService;

    @PostMapping("/joylashnamuna")
    public HttpEntity<?> joylash(@RequestBody NamunaDTO namunaDTO){
        ApiResponse apiResponse=namunaService.joylash(namunaDTO);
        return ResponseEntity.status(apiResponse.isXolat()?200:208).body(apiResponse.getXabar());
    }
    @PutMapping("/taxrirlash/{id}")
    public HttpEntity<?>taxrirlash(@PathVariable Integer id,@RequestBody NamunaDTO namunaDTO){
        ApiResponse apiResponse=namunaService.taxrirlash(id,namunaDTO);
        return ResponseEntity.status(apiResponse.isXolat()?200:208).body(apiResponse.getXabar());

    }
    @GetMapping("/oqish")
    public HttpEntity<?>oqish(){
        ApiResponse apiResponse=namunaService.oqish();
        return ResponseEntity.status(apiResponse.isXolat()?200:208).body(apiResponse.getXabar());
    }
    @GetMapping("/oqishid/{id}")
    public HttpEntity<?>oqishid(@PathVariable Integer id){
        ApiResponse apiResponse=namunaService.oqishid(id);
        return ResponseEntity.status(apiResponse.isXolat()?200:208).body(apiResponse.getXabar());
    }
    @DeleteMapping ("/deleteid/{id}")
    public HttpEntity<?> deleteid(@PathVariable Integer id){
        ApiResponse apiResponse=namunaService.deleteid(id);
        return ResponseEntity.status(apiResponse.isXolat()?200:208).body(apiResponse.getXabar());
    }
}
