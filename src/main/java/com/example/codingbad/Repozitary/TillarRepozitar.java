package com.example.codingbad.Repozitary;

import com.example.codingbad.Entite.Categoriya;
import com.example.codingbad.Entite.Tillar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TillarRepozitar extends JpaRepository<Tillar,Integer> {
}
