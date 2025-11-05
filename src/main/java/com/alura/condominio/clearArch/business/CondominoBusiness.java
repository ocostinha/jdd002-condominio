package com.alura.condominio.clearArch.business;

import com.alura.condominio.clearArch.domain.Condomino;

import java.util.List;

public interface CondominoBusiness {

    Condomino cadastrarCondomino(Condomino novoCondomino);

    void deletarCondomino(String id);

    List<Condomino> consultarTodosCondominos();

}
