package com.example.codingbad.Entite;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Savollar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    @Column(nullable = false)
    private String nomi;
    @Column(nullable = false)
    private String matn;
    @Column(nullable = false)
    private String yechim;
    @Column(nullable = false)
    private String funksiya;
    @Column(nullable = false)
    private String yordam;
    @OneToMany
    private List<Namuna> namunaList;
    @OneToOne
    private  Tillar tillar;
}
