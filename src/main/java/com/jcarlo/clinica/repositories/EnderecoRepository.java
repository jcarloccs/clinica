package com.jcarlo.clinica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jcarlo.clinica.entities.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long>{
    
}
