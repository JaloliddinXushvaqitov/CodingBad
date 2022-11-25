package com.example.codingbad.DTO;

import com.example.codingbad.Entite.Royxatdan_otish;
import com.example.codingbad.Entite.Savollar;
import lombok.Data;
import org.springframework.stereotype.Service;

import javax.persistence.OneToOne;

@Data
public class JavoblarDTO {
    private String javobtekshirish;
    private Integer savollarid;
    private Integer royxatdanid;

}
