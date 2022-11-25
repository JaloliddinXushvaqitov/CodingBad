package com.example.codingbad.Repozitary;

import com.example.codingbad.Entite.Categoriya;
import com.example.codingbad.Entite.Savollar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SavolRepozitary extends JpaRepository<Savollar,Integer> {
}
