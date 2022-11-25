package com.example.codingbad.Service;

import com.example.codingbad.DTO.ApiResponse;
import com.example.codingbad.DTO.CategoriyaDto;
import com.example.codingbad.Entite.Categoriya;
import com.example.codingbad.Repozitary.CategoriyaRepozitary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriyaService {
    @Autowired
    CategoriyaRepozitary categoriyaRepozitary;
    public ApiResponse joylash(CategoriyaDto categoriyaDto) {
        Categoriya categoriya=new Categoriya();
        categoriya.setMatn(categoriyaDto.getMatn());
        categoriya.setYulduzcha(categoriyaDto.getYulduzcha());
        categoriya.setIzox(categoriyaDto.getIzox());
        categoriyaRepozitary.save(categoriya);
        return new ApiResponse("Malumot saqlandi!!!",true);
    }

    public ApiResponse taxrirlashid(Integer id, CategoriyaDto categoriyaDto) {
        Optional<Categoriya> all=categoriyaRepozitary.findById(id);
        if(all.isPresent()){
            Categoriya categoriya=all.get();
            categoriya.setMatn(categoriyaDto.getMatn());
            categoriya.setIzox(categoriyaDto.getIzox());
            categoriya.setYulduzcha(categoriyaDto.getYulduzcha());
            categoriyaRepozitary.save(categoriya);
            return new ApiResponse("Malumot taxrirlandi",true);
        }
        return  new ApiResponse("Malumot mavjudmas!!!",false);
    }

    public ApiResponse oqish() {
        List<Categoriya> all=categoriyaRepozitary.findAll();
        return new ApiResponse(all.toString(),true);
    }

    public ApiResponse oqishid(Integer id) {
        Optional<Categoriya>all=categoriyaRepozitary.findById(id);
        if(all.isPresent()) return new ApiResponse(all.toString(),true);
        return new ApiResponse("Malumot mavjud emas",false);
    }

    public ApiResponse deleteid(Integer id) {
        Optional<Categoriya>deleteid=categoriyaRepozitary.findById(id);
        if(deleteid.isPresent()) {
            categoriyaRepozitary.deleteById(id);
            return new ApiResponse("Malumot ochirildi", true);
        }
        return new ApiResponse("Malumot mavjudmas",false);
    }
}
