package com.example.codingbad.DTO;

import com.example.codingbad.Entite.Namuna;
import com.example.codingbad.Entite.Tillar;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Data
public class SavollarDTO {
    private String nomi;
    private String matn;
    private String yechim;
    private String funksiya;
    private String yordam;
    private List<Integer> namunaList;
    private Integer tillarid;
}
