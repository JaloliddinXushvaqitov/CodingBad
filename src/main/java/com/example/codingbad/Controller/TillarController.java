package com.example.codingbad.Controller;

import com.example.codingbad.DTO.ApiResponse;
import com.example.codingbad.DTO.TillarDTO;
import com.example.codingbad.Service.TillarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Tillar")
public class TillarController {
    @Autowired
    TillarService tillarService;

    @PostMapping("/Joylash")
    public HttpEntity<?> qoshish(@RequestBody TillarDTO tillarDTO){
        ApiResponse apiResponse=tillarService.joylash(tillarDTO);
        return ResponseEntity.status(apiResponse.isXolat()?200:208).body(apiResponse.getXabar());

    }
    @PutMapping("/Taxrirlashtillar/{id}")
    public HttpEntity<?>Taxrirlash(@PathVariable Integer id,@RequestBody TillarDTO tillarDTO){
        ApiResponse apiResponse=tillarService.taxrirlash(id,tillarDTO);
        return ResponseEntity.status(apiResponse.isXolat()?200:208).body(apiResponse.getXabar());

    }
    @GetMapping("/oqishget")
    public HttpEntity<?>oqishget(){
        ApiResponse apiResponse=tillarService.oqishget();
        return ResponseEntity.status(apiResponse.isXolat()?200:208).body(apiResponse.getXabar());
    }
  @GetMapping("/oqish/{id}")
    public HttpEntity<?>oqishid(@PathVariable Integer id){
        ApiResponse apiResponse=tillarService.oqishid(id);
      return ResponseEntity.status(apiResponse.isXolat()?200:208).body(apiResponse.getXabar());
  }
}
