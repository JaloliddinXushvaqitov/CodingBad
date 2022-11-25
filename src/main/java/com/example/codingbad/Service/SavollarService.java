package com.example.codingbad.Service;

import com.example.codingbad.DTO.ApiResponse;
import com.example.codingbad.DTO.SavollarDTO;
import com.example.codingbad.Entite.Namuna;
import com.example.codingbad.Entite.Savollar;
import com.example.codingbad.Repozitary.NamunaRepozitary;
import com.example.codingbad.Repozitary.SavolRepozitary;
import com.example.codingbad.Repozitary.TillarRepozitar;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SavollarService {
    @Autowired
    SavolRepozitary savolRepozitary;
    @Autowired
    TillarRepozitar tillarRepozitar;
    @Autowired
    NamunaRepozitary namunaRepozitary;

    public ApiResponse joylash(SavollarDTO savollarDTO) {
        Savollar savollar=new Savollar();
        savollar.setMatn(savollarDTO.getMatn());
        savollar.setYechim(savollarDTO.getYechim());
        savollar.setYordam(savollarDTO.getYordam());
        savollar.setFunksiya(savollarDTO.getFunksiya());
        savollar.setNomi(savollarDTO.getNomi());
        savollar.setTillar(tillarRepozitar.findById(savollarDTO.getTillarid()).get());
        List<Namuna> all=new ArrayList<>();
        for (Integer integer : savollarDTO.getNamunaList()) {
          all.add(namunaRepozitary.findById(integer).get());
        }
        savollar.setNamunaList(all);
        savolRepozitary.save(savollar);
        return new ApiResponse("malumot joylandi",true);
    }

    public ApiResponse taxrirlash(Integer id, SavollarDTO savollarDTO) {
        Optional<Savollar>all=savolRepozitary.findById(id);
        if(all.isPresent()){
            Savollar savollar=all.get();
            savollar.setYechim(savollarDTO.getYechim());
            savollar.setYordam(savollarDTO.getYordam());
            savollar.setNomi(savollarDTO.getNomi());
            savollar.setFunksiya(savollarDTO.getFunksiya());
            savollar.setMatn(savollarDTO.getMatn());
            savollar.setTillar(tillarRepozitar.findById(savollarDTO.getTillarid()).get());
            List<Namuna> namunaList=new ArrayList<>();
            for (Integer integer : savollarDTO.getNamunaList()) {
                namunaList.add(namunaRepozitary.findById(integer).get());
            }
            savollar.setNamunaList(namunaList);
            savolRepozitary.save(savollar);
            return new ApiResponse("Malumot taxrirlandi",true);
        }
        return new ApiResponse("Malumot topilmadi",false);

    }


    public ApiResponse oqish() {
        List<Savollar> all=savolRepozitary.findAll();
        return new ApiResponse(all.toString(),true);
    }

    public ApiResponse oqishid(Integer id) {
        Optional<Savollar>all=savolRepozitary.findById(id);
        if(all.isPresent()) return new ApiResponse(all.toString(),true);
        return new ApiResponse("Malumot mavjud emas",false);
    }

    public ApiResponse deleteid(Integer id) {
        Optional<Savollar> deleteid=savolRepozitary.findById(id);
        if(deleteid.isPresent()) {
            savolRepozitary.deleteById(id);
            return new ApiResponse("Malumot ochirildi", true);
        }
        return new ApiResponse("Malumot mavjudmas",false);
    }
}
