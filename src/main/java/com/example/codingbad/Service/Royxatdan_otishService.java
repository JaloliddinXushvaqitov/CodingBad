package com.example.codingbad.Service;

import com.example.codingbad.DTO.ApiResponse;
import com.example.codingbad.DTO.Royxatdan_otishDTO;
import com.example.codingbad.Entite.Royxatdan_otish;
import com.example.codingbad.Repozitary.RoyxatRepozitary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Royxatdan_otishService {
   @Autowired
   RoyxatRepozitary royxatRepozitary;
     public ApiResponse qoshish(Royxatdan_otishDTO royxatdan_otishDTO) {
         final Optional<Royxatdan_otish> byEmailAndPassword = royxatRepozitary.findByEmailAndPassword(royxatdan_otishDTO.getPassword(), royxatdan_otishDTO.getEmail());
         if(byEmailAndPassword.isPresent()) return new ApiResponse("Bunday malumoot mavjud",false);
         Royxatdan_otish royxatdan=new Royxatdan_otish();
        royxatdan.setEmail(royxatdan_otishDTO.getPassword());
        royxatdan.setPassword(royxatdan_otishDTO.getPassword());
        royxatRepozitary.save(royxatdan);
        return new ApiResponse("Malumot joylandi",true);
    }
}
