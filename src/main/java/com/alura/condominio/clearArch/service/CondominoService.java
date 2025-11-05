package com.alura.condominio.clearArch.service;

import com.alura.condominio.clearArch.domain.Condomino;

public interface CondominoService {

    boolean exiteCPF(String cpf);

    Condomino cadastrar(Condomino novoCondomino);

}
