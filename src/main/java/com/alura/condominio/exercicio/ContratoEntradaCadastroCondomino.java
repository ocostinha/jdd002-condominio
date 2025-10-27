package com.alura.condominio.exercicio;

import jakarta.validation.constraints.NotNull;

public class ContratoEntradaCadastroCondomino {

    @NotNull
    private String nome;

    private Integer dddCelular;
    private Long numeroCelular;

    @NotNull
    private String email;

    @NotNull
    private String bloco;

    @NotNull
    private String apartamento;

    @NotNull
    private String cpf;

    public String getNome() {
        return nome;
    }

    public void setNome(final String nome) {
        this.nome = nome;
    }

    public Integer getDddCelular() {
        return dddCelular;
    }

    public void setDddCelular(final Integer dddCelular) {
        this.dddCelular = dddCelular;
    }

    public Long getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(final Long numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(final String cpf) {
        this.cpf = cpf;
    }

    public ContratoEntradaCadastroCondomino(final String nome, final Integer dddCelular, final Long numeroCelular, final String email, final String bloco, final String apartamento, final String cpf) {
        this.nome = nome;
        this.dddCelular = dddCelular;
        this.numeroCelular = numeroCelular;
        this.email = email;
        this.bloco = bloco;
        this.apartamento = apartamento;
        this.cpf = cpf;
    }

    public ContratoEntradaCadastroCondomino() {

    }

}
