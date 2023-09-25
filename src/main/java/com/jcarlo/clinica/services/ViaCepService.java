package com.jcarlo.clinica.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.jcarlo.clinica.entities.ViaCep;

@FeignClient(url = "https://viacep.com.br/ws/", name = "viacep")
public interface ViaCepService {
	
	@GetMapping("{cep}/json/")
    ViaCep cep(@PathVariable("cep") String cep);

}
