package com.jcarlo.clinica.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcarlo.clinica.entities.Paciente;
import com.jcarlo.clinica.repositories.PacienteRepository;

@Service
public class PacienteService {
    
    @Autowired
    private PacienteRepository pacienteRepository;

    public List<Paciente> findAll() {
		return pacienteRepository.findAll();
	}
	
	public Paciente findById(Integer cpf) {
		Optional<Paciente> obj = pacienteRepository.findById(cpf);
		return obj.get();
	}
	
	public Paciente insert(Paciente obj) {
		return pacienteRepository.save(obj);
	}
	
	public void delete(Integer cpf) {
		pacienteRepository.deleteById(cpf);
	}
	
	public Paciente update(Integer cpf, Paciente obj) {
        Paciente entity = pacienteRepository.getReferenceById(cpf);
        updateData(entity, obj);
        return pacienteRepository.save(entity);
	}

	private void updateData(Paciente entity, Paciente obj) {
		entity.setEndereco(obj.getEndereco());
		entity.setTelefones(obj.getTelefones());
		entity.setExames(obj.getExames());
	}

}
