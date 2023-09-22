package com.jcarlo.clinica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jcarlo.clinica.entities.Exame;

public interface ExameRepository extends JpaRepository<Exame, Long>{
    
}
