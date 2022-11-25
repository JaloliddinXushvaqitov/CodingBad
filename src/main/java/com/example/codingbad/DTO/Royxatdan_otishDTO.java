package com.example.codingbad.DTO;

import lombok.Data;
import org.springframework.stereotype.Service;

import javax.persistence.Column;
import java.util.List;

@Data
public class Royxatdan_otishDTO {
    private Integer id;
    private String email;
    private String password;
}
