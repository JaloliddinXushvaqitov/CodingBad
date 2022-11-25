package com.example.codingbad.Controller;

import com.example.codingbad.DTO.ApiResponse;
import com.example.codingbad.DTO.NamunaDTO;
import com.example.codingbad.DTO.SavollarDTO;
import com.example.codingbad.Repozitary.SavolRepozitary;
import com.example.codingbad.Service.NamunaService;
import com.example.codingbad.Service.SavollarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/savol")
public class SavollarController {
    @Autowired
    SavollarService savollarService;

    @PostMapping("/joylashsavol")
    public HttpEntity<?> joylash(@RequestBody SavollarDTO savollarDTO){
        ApiResponse apiResponse=savollarService.joylash(savollarDTO);
        return ResponseEntity.status(apiResponse.isXolat()?200:208).body(apiResponse.getXabar());
    }
    @PutMapping("/taxrirlash/{id}")
    public HttpEntity<?>taxrirlash(@PathVariable Integer id,@RequestBody SavollarDTO savollarDTO){
        ApiResponse apiResponse=savollarService.taxrirlash(id,savollarDTO);
        return ResponseEntity.status(apiResponse.isXolat()?200:208).body(apiResponse.getXabar());

    }
    @GetMapping("/oqish")
    public HttpEntity<?>oqish(){
        ApiResponse apiResponse=savollarService.oqish();
        return ResponseEntity.status(apiResponse.isXolat()?200:208).body(apiResponse.getXabar());
    }
    @GetMapping("/oqishid/{id}")
    public HttpEntity<?>oqishid(@PathVariable Integer id){
        ApiResponse apiResponse=savollarService.oqishid(id);
        return ResponseEntity.status(apiResponse.isXolat()?200:208).body(apiResponse.getXabar());
    }
    @DeleteMapping ("/deleteid/{id}")
    public HttpEntity<?> deleteid(@PathVariable Integer id){
        ApiResponse apiResponse=savollarService.deleteid(id);
        return ResponseEntity.status(apiResponse.isXolat()?200:208).body(apiResponse.getXabar());
    }
}
