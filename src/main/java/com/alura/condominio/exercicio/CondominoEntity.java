package com.alura.condominio.exercicio;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "condomino")
public class CondominoEntity {

    @Id
    private String id;

    private String nome;
    private Integer dddCelular;
    private Long numeroCelular;
    private String email;
    private String bloco;
    private String apartamento;
    private String cpf;

    public CondominoEntity(final String id, final String nome, final Integer dddCelular, final Long numeroCelular, final String email, final String bloco, final String apartamento, final String cpf) {
        this.id = id;
        this.nome = nome;
        this.dddCelular = dddCelular;
        this.numeroCelular = numeroCelular;
        this.email = email;
        this.bloco = bloco;
        this.apartamento = apartamento;
        this.cpf = cpf;
    }

    public CondominoEntity() {
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

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

}
