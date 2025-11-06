package com.alura.condominio.clearArch.service.impl;

import com.alura.condominio.clearArch.domain.Condomino;
import com.alura.condominio.clearArch.service.CondominoService;
import com.alura.condominio.clearArch.service.adapter.CondominoServiceAdapter;
import com.alura.condominio.clearArch.service.repository.CondominoRepository;
import com.alura.condominio.clearArch.service.repository.entity.CondominoEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CondominoServiceImpl implements CondominoService {

    private CondominoRepository condominoRepository;
    private CondominoServiceAdapter condominoAdapter;

    @Override
    public boolean exiteCPF(final String cpf) {
        return condominoRepository.findByCpf(cpf).isPresent();
    }

    @Override
    public Condomino cadastrar(final Condomino novoCondomino) {
        return condominoAdapter.toDomain(
            condominoRepository.save(
                condominoAdapter.toEntity(novoCondomino)
            )
        );
    }

    @Override
    public boolean existeCondomino(final String id) {
        return condominoRepository.findById(id).isPresent();
    }

    @Override
    public void deletar(final String id) {
        condominoRepository.deleteById(id);
    }

    @Override
    public List<Condomino> consultarTodos() {
        return condominoRepository.findAll()
            .stream()
            .map(condominoAdapter::toDomain)
            .toList();
    }

    @Override
    public Condomino atualizar(final Condomino condominoEsperandoAtualizacao) {
        CondominoEntity condominoExistente = condominoRepository.findById(condominoEsperandoAtualizacao.getId()).get();
        CondominoEntity condominoAtualizado = condominoAdapter.update(condominoExistente, condominoEsperandoAtualizacao);

        return condominoAdapter.toDomain(
            condominoRepository.save(
                condominoAtualizado
            )
        );
    }

    @Override
    public List<Condomino> consultarPorFiltros(final String nome, final String cpf, final String bloco, final String apartamento) {
        return condominoRepository.findByNomeCompletoContainingIgnoreCaseAndCpfContainingIgnoreCaseAndBlocoContainingIgnoreCaseAndApartamentoContainingIgnoreCase(nome, cpf, bloco, apartamento)
            .stream()
            .map(condominoAdapter::toDomain)
            .toList();
    }

}
