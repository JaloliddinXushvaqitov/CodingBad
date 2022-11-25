package com.example.codingbad.DTO;

import com.example.codingbad.Entite.Categoriya;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.stereotype.Service;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.List;

@Data
public class TillarDTO {
    private String tilnomi;
    private List<Categoriya> categoriyaList;
}
