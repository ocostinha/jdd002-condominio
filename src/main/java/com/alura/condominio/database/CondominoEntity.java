package com.alura.condominio.database;

import com.alura.condominio.contratos.ContratoEntradaAtualizacaoCondomino;
import com.alura.condominio.contratos.ContratoEntradaCadastroCondomino;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

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

    public CondominoEntity fromContratoEntrada(ContratoEntradaCadastroCondomino contratoEntrada) {
        CondominoEntity condominoEntity = new CondominoEntity();

        condominoEntity.setId(UUID.randomUUID().toString());
        condominoEntity.setNomeCompleto(contratoEntrada.getNomeCompleto());
        condominoEntity.setCpf(contratoEntrada.getCpf());
        condominoEntity.setEmail(contratoEntrada.getEmail());
        condominoEntity.setTelefone(contratoEntrada.getTelefone());
        condominoEntity.setBloco(contratoEntrada.getBloco());
        condominoEntity.setApartamento(contratoEntrada.getApartamento());

        return condominoEntity;
    }

    public CondominoEntity atualizarCondomino(CondominoEntity condominoEntity, ContratoEntradaAtualizacaoCondomino contratoEntrada) {
        condominoEntity.setNomeCompleto(contratoEntrada.getNomeCompleto());
        condominoEntity.setEmail(contratoEntrada.getEmail());
        condominoEntity.setTelefone(contratoEntrada.getTelefone());
        condominoEntity.setBloco(contratoEntrada.getBloco());
        condominoEntity.setApartamento(contratoEntrada.getApartamento());

        return condominoEntity;
    }

}
