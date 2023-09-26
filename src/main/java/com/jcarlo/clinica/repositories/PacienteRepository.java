package com.jcarlo.clinica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jcarlo.clinica.entities.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, String> {
    
}
