package com.alura.condominio.contratos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ContratoEntradaCadastroCondomino {

    @NotNull
    @NotEmpty
    @NotBlank
    private String nomeCompleto;

    @NotEmpty
    @NotNull
    @NotBlank
    @Size(min = 11, max = 11, message = "Digite os 11 caracteres do CPF, sem traço ou ponto")
    private String cpf;

    private String email;
    private String telefone;

    @NotNull
    @NotBlank
    @NotEmpty
    private String bloco;

    @NotNull
    @NotBlank
    @NotEmpty
    private String apartamento;

    public ContratoEntradaCadastroCondomino() {
    }

    public ContratoEntradaCadastroCondomino(final String nomeCompleto, final String cpf, final String email, final String telefone, final String bloco, final String apartamento) {
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.bloco = bloco;
        this.apartamento = apartamento;
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
