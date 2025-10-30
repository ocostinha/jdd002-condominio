package com.alura.condominio.database;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CondominoEntity {

    @Id
    private String id;
    private String nomeCompleto;
    private String cpf;
    private String email;
    private String telefone;
    private String bloco;
    private String apartamento;

}
