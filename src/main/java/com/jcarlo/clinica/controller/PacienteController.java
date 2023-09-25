package com.jcarlo.clinica.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jcarlo.clinica.entities.Exame;
import com.jcarlo.clinica.entities.Paciente;
import com.jcarlo.clinica.services.PacienteService;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;
    
    @GetMapping
	public ResponseEntity<List<Paciente>> findAll() {
		List<Paciente> list = pacienteService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{cpf}")
	public ResponseEntity<Paciente> findById(@PathVariable Integer cpf) {
		Paciente obj = pacienteService.findById(cpf);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Paciente> insert(@RequestBody Paciente obj) {
		obj = pacienteService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{cpf}")
			.buildAndExpand(obj.getCpf())
			.toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{cpf}")
	public ResponseEntity<Void> delete(@PathVariable Integer cpf) {
		pacienteService.delete(cpf);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{cpf}")
	public ResponseEntity<Paciente> update(@PathVariable Integer cpf, @RequestBody Paciente obj) {
		obj = pacienteService.update(cpf, obj);
		return ResponseEntity.ok().body(obj);
	}

    @PutMapping(value = "/exame/{cpf}")
	public ResponseEntity<Paciente> insertExame(@PathVariable Integer cpf, @RequestBody Exame obj) {
		Paciente paciente = pacienteService.insertExames(cpf, obj);
		return ResponseEntity.ok().body(paciente);
	}

}
