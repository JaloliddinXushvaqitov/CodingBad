package com.example.codingbad.Controller;

import com.example.codingbad.DTO.ApiResponse;
import com.example.codingbad.DTO.CategoriyaDto;
import com.example.codingbad.DTO.JavoblarDTO;
import com.example.codingbad.DTO.SavollarDTO;
import com.example.codingbad.Service.JavoblarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/javoblar")
public class JavoblarController {
    @Autowired
    JavoblarService javoblarService;

    @PostMapping("/qoshishjavob")
    public HttpEntity<?> qoshish(@RequestBody JavoblarDTO javoblarDTO){
        ApiResponse apiResponse=javoblarService.qoshishjavob(javoblarDTO);
        return ResponseEntity.status(apiResponse.isXolat()?200:208).body(apiResponse.getXabar());
    }
    @PutMapping("/Taxrirlashjavob/{id}")
    public HttpEntity<?>taxrirlash(@PathVariable Integer id, @RequestBody JavoblarDTO javoblarDTO){
        ApiResponse apiResponse=javoblarService.taxrirlashid(id,javoblarDTO);
        return ResponseEntity.status(apiResponse.isXolat()?200:208).body(apiResponse.getXabar());
    }
    @GetMapping("/oqish")
    public HttpEntity<?> oqish(){
        ApiResponse apiResponse=javoblarService.oqish();
        return ResponseEntity.status(apiResponse.isXolat()?200:208).body(apiResponse.getXabar());
    }
    @GetMapping("/oqishid/{id}")
    public HttpEntity<?>Oqishid(@PathVariable Integer id){
        ApiResponse apiResponse=javoblarService.oqishid(id);
        return ResponseEntity.status(apiResponse.isXolat()?200:208).body(apiResponse.getXabar());
    }
    @DeleteMapping("/deleteid/{id}")
    public HttpEntity<?>deleteid(@PathVariable Integer id){
        ApiResponse apiResponse=javoblarService.deleteid(id);
        return ResponseEntity.status(apiResponse.isXolat()?200:208).body(apiResponse.getXabar());
    }
}
