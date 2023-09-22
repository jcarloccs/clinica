package com.jcarlo.clinica.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_pacientes")
public class Paciente implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private Integer cpf;

    @Column(nullable = false)
    private String nome;
    private Date dataNasc;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Telefone> telefones = new ArrayList<>();

    @OneToOne
    private Endereco endereco;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Exame> exames = new ArrayList<>();

    public Paciente() {
    }

    public Paciente(Integer cpf, String nome, Date dataNasc, List<Telefone> telefones, Endereco endereco,
            List<Exame> exames) {
        this.cpf = cpf;
        this.nome = nome;
        this.dataNasc = dataNasc;
        this.telefones = telefones;
        this.endereco = endereco;
        this.exames = exames;
    }

    public Integer getCpf() {
        return cpf;
    }

    public void setCpf(Integer cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Exame> getExames() {
        return exames;
    }

    public void setExames(List<Exame> exames) {
        this.exames = exames;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Paciente other = (Paciente) obj;
        if (cpf == null) {
            if (other.cpf != null)
                return false;
        } else if (!cpf.equals(other.cpf))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Paciente [cpf=" + cpf + ", nome=" + nome + ", dataNasc=" + dataNasc + ", telefones=" + telefones
                + ", endereco=" + endereco + ", exames=" + exames + "]";
    }

}
