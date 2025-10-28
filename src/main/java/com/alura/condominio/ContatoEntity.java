package com.alura.condominio;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "contato")
public class ContatoEntity {

    @Id
    @Column
    private String id;

    @Column(name = "nome")
    private String nome;

    @Column
    private String cpf;

    public ContatoEntity(final String id, final String nome, final String cpf) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
    }

    public ContatoEntity() {
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(final String cpf) {
        this.cpf = cpf;
    }

}
