package com.example.codingbad.Service;

import com.example.codingbad.DTO.ApiResponse;
import com.example.codingbad.DTO.TillarDTO;
import com.example.codingbad.Entite.Categoriya;
import com.example.codingbad.Entite.Tillar;
import com.example.codingbad.Repozitary.CategoriyaRepozitary;
import com.example.codingbad.Repozitary.TillarRepozitar;
import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TillarService {
    @Autowired
    CategoriyaRepozitary categoriyaRepozitary;
    @Autowired
    TillarRepozitar tillarRepozitar;
    public ApiResponse joylash(TillarDTO tillarDTO) {
        Tillar tillar=new Tillar();
        tillar.setTilnomi(tillarDTO.getTilnomi());
        List<Categoriya> categoriyaList=new ArrayList<>();
        for (Categoriya categoriya : tillarDTO.getCategoriyaList()) {
            Categoriya categoriya1=new Categoriya();
            categoriya1.setMatn(categoriya.getMatn());
            categoriya1.setIzox(categoriya.getIzox());
            categoriya1.setYulduzcha(categoriya.getYulduzcha());
            categoriyaList.add(categoriya1);
            categoriyaRepozitary.save(categoriya1);
        }

        tillar.setCategoriyaList(categoriyaList);
        tillarRepozitar.save(tillar);
        return new ApiResponse("malumot saqlandi",true);
    }

    public ApiResponse taxrirlash(Integer id, TillarDTO tillarDTO) {
        Optional<Tillar> all=tillarRepozitar.findById(id);
        if(all.isPresent()){
            Tillar tillar=all.get();
            tillar.setTilnomi(tillarDTO.getTilnomi());
            return new ApiResponse("Mmalumot taxrirlandi",true);
        }
        return new ApiResponse("Malumot taxrirlanmadi",false);
    }

    public ApiResponse oqishget() {
        List<Tillar> all=tillarRepozitar.findAll();
        return new ApiResponse(all.toString(),true);
    }


    public ApiResponse oqishid(Integer id) {
        Optional<Tillar>all=tillarRepozitar.findById(id);
        return new ApiResponse(all.toString(),true);
    }
}
