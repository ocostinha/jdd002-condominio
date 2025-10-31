package com.alura.condominio.adapter;

import com.alura.condominio.contratos.ContratoEntradaAtualizacaoCondomino;
import com.alura.condominio.contratos.ContratoEntradaCadastroCondomino;
import com.alura.condominio.database.CondominoEntity;

import java.util.UUID;

public class CondominoAdapter {

    public static CondominoEntity toEntity(ContratoEntradaCadastroCondomino contratoEntrada) {
        CondominoEntity condominoEntity = new CondominoEntity();

        condominoEntity.setId(UUID.randomUUID().toString());
        condominoEntity.setNomeCompleto(contratoEntrada.getNomeCompleto());
        condominoEntity.setCpf(contratoEntrada.getCpf());
        condominoEntity.setEmail(contratoEntrada.getEmail());
        condominoEntity.setTelefone(contratoEntrada.getTelefone());
        condominoEntity.setTelefoneContato(contratoEntrada.getTelefoneContato());
        condominoEntity.setBloco(contratoEntrada.getBloco());
        condominoEntity.setApartamento(contratoEntrada.getApartamento());

        return condominoEntity;
    }

    public static CondominoEntity update(CondominoEntity condominoEntity, ContratoEntradaAtualizacaoCondomino contratoEntrada) {
        condominoEntity.setNomeCompleto(contratoEntrada.getNomeCompleto());
        condominoEntity.setEmail(contratoEntrada.getEmail());
        condominoEntity.setTelefone(contratoEntrada.getTelefone());
        condominoEntity.setTelefoneContato(contratoEntrada.getTelefoneContato());
        condominoEntity.setBloco(contratoEntrada.getBloco());
        condominoEntity.setApartamento(contratoEntrada.getApartamento());

        return condominoEntity;
    }
}
