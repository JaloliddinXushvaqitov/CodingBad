package com.example.codingbad.Repozitary;

import com.example.codingbad.Entite.Categoriya;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriyaRepozitary extends JpaRepository<Categoriya,Integer> {
}
