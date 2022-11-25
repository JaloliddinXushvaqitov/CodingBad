package com.example.codingbad.Repozitary;

import com.example.codingbad.Entite.Categoriya;
import com.example.codingbad.Entite.Namuna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NamunaRepozitary extends JpaRepository<Namuna,Integer> {
}
