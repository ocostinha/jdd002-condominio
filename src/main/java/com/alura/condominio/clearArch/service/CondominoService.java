package com.alura.condominio.clearArch.service;

import com.alura.condominio.clearArch.domain.Condomino;

import java.util.List;

public interface CondominoService {

    boolean exiteCPF(String cpf);

    Condomino cadastrar(Condomino novoCondomino);

    boolean existeCondomino(String id);

    void deletar(String id);

    List<Condomino> consultarTodos();

    Condomino atualizar(Condomino condominoEsperandoAtualizacao);

    List<Condomino> consultarPorFiltros(String nome, String cpf, String bloco, String apartamento);

}
