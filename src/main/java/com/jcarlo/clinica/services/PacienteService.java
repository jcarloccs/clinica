package com.jcarlo.clinica.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcarlo.clinica.entities.Exame;
import com.jcarlo.clinica.entities.Paciente;
import com.jcarlo.clinica.entities.Telefone;
import com.jcarlo.clinica.entities.ViaCep;
import com.jcarlo.clinica.repositories.EnderecoRepository;
import com.jcarlo.clinica.repositories.ExameRepository;
import com.jcarlo.clinica.repositories.PacienteRepository;
import com.jcarlo.clinica.repositories.TelefoneRepository;

@Service
public class PacienteService {
    
    @Autowired
    private PacienteRepository pacienteRepository;

	@Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ExameRepository exameRepository;

    @Autowired
    private TelefoneRepository telefoneRepository;

	@Autowired
	private ViaCepService viaCepService;

    public List<Paciente> findAll() {
		return pacienteRepository.findAll();
	}
	
	public Paciente findById(Integer cpf) {
		return pacienteRepository.findById(cpf).orElseThrow(NoSuchElementException::new);
	}
	
	public Paciente insert(Paciente obj) {
		if(pacienteRepository.existsById(obj.getCpf())) {
			throw new IllegalArgumentException("Paciente já existe");
		}

		if (obj.getEndereco().getCep().toString().length() == 8) {
			ViaCep viaCep = viaCepService.cep(obj.getEndereco().getCep().toString());
		
			if (viaCep.getErro() == null) {
				obj.getEndereco().setCidade(viaCep.getLocalidade());
				obj.getEndereco().setEstado(viaCep.getUf());
				obj.getEndereco().setRua(viaCep.getLogradouro());
				obj.getEndereco().setBairro(viaCep.getBairro());
				obj.getEndereco().setComplemento(viaCep.getComplemento());
			}
		}
		enderecoRepository.save(obj.getEndereco());
		
		for (Exame exame : obj.getExames()) {
			exameRepository.save(exame);
		}

		for (Telefone telefone : obj.getTelefones()) {
			telefoneRepository.save(telefone);
		}

		return pacienteRepository.save(obj);
	}
	
	public void delete(Integer cpf) {
		if(!pacienteRepository.existsById(cpf)) {
			throw new IllegalArgumentException("Paciente não cadastrado");
		}
		pacienteRepository.deleteById(cpf);
	}
	
	public Paciente update(Integer cpf, Paciente obj) {
		if(!pacienteRepository.existsById(cpf)) {
			throw new IllegalArgumentException("Paciente não cadastrado");
		}
        Paciente entity = pacienteRepository.getReferenceById(cpf);
        updateData(entity, obj);
        return pacienteRepository.save(entity);
	}

	public Paciente insertExames(Integer cpf, Exame exame) {
		if(!pacienteRepository.existsById(cpf)) {
			throw new IllegalArgumentException("Paciente não cadastrado");
		}
        Paciente entity = pacienteRepository.getReferenceById(cpf);
		entity.getExames().add(exame);
		exameRepository.save(exame);
		return pacienteRepository.save(entity);
	}

	private void updateData(Paciente entity, Paciente obj) {
		entity.setEndereco(obj.getEndereco());
		entity.setTelefones(obj.getTelefones());
	}

}
