package com.example.codingbad.Repozitary;

import com.example.codingbad.Entite.Royxatdan_otish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoyxatRepozitary extends JpaRepository<Royxatdan_otish,Integer> {
    Optional<Royxatdan_otish> findByEmailAndPassword(String email, String password);
}
