package com.alura.condominio.clearArch.business.impl;

import com.alura.condominio.clearArch.business.CondominoBusiness;
import com.alura.condominio.clearArch.core.exceptions.RecursoNaoEncontradoException;
import com.alura.condominio.clearArch.domain.Condomino;
import com.alura.condominio.clearArch.service.CondominoService;
import com.alura.condominio.clearArch.core.exceptions.RegraDeNegocioException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class CondominoBusinessImpl implements CondominoBusiness {

    private CondominoService condominoService;

    @Override
    public Condomino cadastrarCondomino(final Condomino novoCondomino) {
        if (condominoService.exiteCPF(novoCondomino.getCpf())) {
            throw new RegraDeNegocioException("CPF já cadastrado");
        }

        Condomino condominoSalvo = condominoService.cadastrar(novoCondomino);

        return condominoSalvo;
    }

    @Override
    public void deletarCondomino(final String id) {
        if (!condominoService.existeCondomino(id)) {
            throw new RecursoNaoEncontradoException("Condomino não encontrado");
        }

        condominoService.deletar(id);
    }

    @Override
    public List<Condomino> consultarTodosCondominos() {
        return condominoService.consultarTodos();
    }

}
