package com.alura.condominio.database;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CondominoEntity {

    @Id
    private String id;
    private String nomeCompleto;
    private String cpf;
    private String email;
    private String telefone;
    private String bloco;
    private String apartamento;

    public CondominoEntity() {
    }

    public CondominoEntity(final String id, final String nomeCompleto, final String cpf, final String email, final String telefone, final String bloco, final String apartamento) {
        this.id = id;
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.bloco = bloco;
        this.apartamento = apartamento;
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(final String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(final String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(final String telefone) {
        this.telefone = telefone;
    }

    public String getBloco() {
        return bloco;
    }

    public void setBloco(final String bloco) {
        this.bloco = bloco;
    }

    public String getApartamento() {
        return apartamento;
    }

    public void setApartamento(final String apartamento) {
        this.apartamento = apartamento;
    }

}
