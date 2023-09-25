package com.jcarlo.clinica;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.jcarlo.clinica.entities.Endereco;
import com.jcarlo.clinica.entities.Exame;
import com.jcarlo.clinica.entities.Paciente;
import com.jcarlo.clinica.entities.Telefone;
import com.jcarlo.clinica.repositories.EnderecoRepository;
import com.jcarlo.clinica.repositories.ExameRepository;
import com.jcarlo.clinica.repositories.PacienteRepository;
import com.jcarlo.clinica.repositories.TelefoneRepository;

@Configuration
public class TestConfig implements CommandLineRunner{

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ExameRepository exameRepository;

    @Autowired
    private TelefoneRepository telefoneRepository;

    @Override
    public void run(String... args) throws Exception {

        Endereco endereco = new Endereco(null, 405, "b", "c", "d", "e", "f", "g");
        Exame exame = new Exame(null, "x", 20.6, true);
        Telefone telefone = new Telefone(null, "876596");

        enderecoRepository.save(endereco);
        exameRepository.save(exame);
        telefoneRepository.save(telefone);

        Paciente paciente = new Paciente(47587, 
        "eu", new Date(), Arrays.asList(telefone), endereco, Arrays.asList(exame));

        pacienteRepository.save(paciente);

    }
    
}
