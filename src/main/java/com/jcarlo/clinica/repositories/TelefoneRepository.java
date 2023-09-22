package com.jcarlo.clinica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jcarlo.clinica.entities.Telefone;

public interface TelefoneRepository extends JpaRepository<Telefone, Long> {
    
}
