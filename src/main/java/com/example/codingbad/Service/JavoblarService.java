package com.example.codingbad.Service;

import com.example.codingbad.DTO.ApiResponse;
import com.example.codingbad.DTO.JavoblarDTO;
import com.example.codingbad.Entite.Javoblar;
import com.example.codingbad.Entite.Savollar;
import com.example.codingbad.Repozitary.JavoblarRepozitary;
import com.example.codingbad.Repozitary.RoyxatRepozitary;
import com.example.codingbad.Repozitary.SavolRepozitary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JavoblarService {
@Autowired
    JavoblarRepozitary javoblarRepozitary;
@Autowired
    RoyxatRepozitary royxatRepozitary;
@Autowired
    SavolRepozitary savolRepozitary;
    public ApiResponse qoshish(JavoblarDTO javoblarDTO) {
        Javoblar javoblar=new Javoblar();
        javoblar.setJavobtekshirish(javoblarDTO.getJavobtekshirish());
        javoblar.setRoyxatdan_otish(royxatRepozitary.findById(javoblarDTO.getRoyxatdanid()).get());
        javoblar.setSavollar(savolRepozitary.findById(javoblarDTO.getSavollarid()).get());
        javoblarRepozitary.save(javoblar);
        return new ApiResponse("Malumot saqlandi",true);
    }

    public ApiResponse deleteid(Integer id) {
      Optional<Javoblar> all=javoblarRepozitary.findById(id);
      if(all.isPresent()){
          javoblarRepozitary.deleteById(id);
          return new ApiResponse("malumot ochirildi",true);
      }
        return new ApiResponse("malumot topilmadi",false);

    }

    public ApiResponse oqishid(Integer id) {
        Optional<Javoblar>all=javoblarRepozitary.findById(id);
        if(all.isPresent()) return new ApiResponse(all.toString(),true);
        return new ApiResponse("Malumot mavjud emas",false);
    }

    public ApiResponse oqish() {
        List<Javoblar> all=javoblarRepozitary.findAll();
        return new ApiResponse(all.toString(),true);
    }


    public ApiResponse taxrirlashid(Integer id, JavoblarDTO javoblarDTO) {
        Optional<Javoblar>all=javoblarRepozitary.findById(id);
        if(all.isPresent()){
            Javoblar javoblar=all.get();
            javoblar.setJavobtekshirish(javoblarDTO.getJavobtekshirish());
            javoblar.setSavollar(savolRepozitary.findById(javoblarDTO.getRoyxatdanid()).get());
            javoblar.setRoyxatdan_otish(royxatRepozitary.findById(javoblarDTO.getRoyxatdanid()).get());
            javoblarRepozitary.save(javoblar);
            return new ApiResponse("Malumot taxrirlandi",true);
        }
        return new ApiResponse("Malumot topilmadi",false);
    }

    public ApiResponse qoshishjavob(JavoblarDTO javoblarDTO) {
        Javoblar javoblar=new Javoblar();
        javoblar.setJavobtekshirish(javoblarDTO.getJavobtekshirish());
        javoblar.setRoyxatdan_otish(royxatRepozitary.findById(javoblarDTO.getRoyxatdanid()).get());
        javoblar.setSavollar(savolRepozitary.findById(javoblarDTO.getSavollarid()).get());
        javoblarRepozitary.save(javoblar);
        return new ApiResponse("Malumot saqlandi",true);
    }
}
