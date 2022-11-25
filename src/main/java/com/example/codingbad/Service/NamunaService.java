package com.example.codingbad.Service;

import com.example.codingbad.DTO.ApiResponse;
import com.example.codingbad.DTO.NamunaDTO;
import com.example.codingbad.Entite.Categoriya;
import com.example.codingbad.Entite.Namuna;
import com.example.codingbad.Repozitary.NamunaRepozitary;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

@Service
public class NamunaService {
@Autowired
    NamunaRepozitary namunaRepozitary;
    public ApiResponse joylash(NamunaDTO namunaDTO) {
        Namuna namuna=new Namuna();
        namuna.setMatn(namunaDTO.getMatn());
        namunaRepozitary.save(namuna);
        return new ApiResponse("malumot saqlandi",true);
    }

    public ApiResponse taxrirlash(Integer id, NamunaDTO namunaDTO) {
        Optional<Namuna>all=namunaRepozitary.findById(id);
        if(all.isPresent()){
            Namuna namuna=all.get();
            namuna.setMatn(namunaDTO.getMatn());
            return new ApiResponse("Malumot taxrirlandi!!!",true);
        }
        return new ApiResponse("malumot mavjudmas!!!",false);
    }

    public ApiResponse oqish() {
        List<Namuna> all=namunaRepozitary.findAll();
        return new ApiResponse(all.toString(),true);
    }

    public ApiResponse oqishid(Integer id) {
        Optional<Namuna>all=namunaRepozitary.findById(id);
        if(all.isPresent()) return new ApiResponse(all.toString(),true);
        return new ApiResponse("Malumot mavjud emas",false);
    }

    public ApiResponse deleteid(Integer id) {
        Optional<Namuna>deleteid=namunaRepozitary.findById(id);
        if(deleteid.isPresent()) {
            namunaRepozitary.deleteById(id);
            return new ApiResponse("Malumot ochirildi", true);
        }
        return new ApiResponse("Malumot mavjudmas",false);
    }
}
