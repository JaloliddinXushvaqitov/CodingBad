package com.example.codingbad.Entite;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Javoblar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    @Column(nullable = false)
    private String javobtekshirish;

    @OneToOne
    private Savollar savollar;
    @OneToOne
    private Royxatdan_otish royxatdan_otish;
}
