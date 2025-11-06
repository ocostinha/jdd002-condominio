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
        CondominoEntity novoCondominoConvertido = condominoAdapter.toEntity(novoCondomino);

        CondominoEntity condominoCadastrado = condominoRepository.save(novoCondominoConvertido);

        return condominoAdapter.toDomain(condominoCadastrado);
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
        List<CondominoEntity> condominos = condominoRepository.findAll();

//        List<Condomino> condominosConvertidos = new ArrayList<>();
//
//        condominos.forEach(condomino -> {
//            condominosConvertidos.add(condominoAdapter.toDomain(condomino));
//        });
//
//        return condominosConvertidos;

        return condominos.stream().map(condominoAdapter::toDomain).toList();
    }

    @Override
    public Condomino atualizar(final Condomino condominoEsperandoAtualizacao) {
//        CondominoEntity condominoExistente = condominoRepository.findById(condominoEsperandoAtualizacao.getId()).get();
//
//        condominoExistente.setApartamento(condominoEsperandoAtualizacao.getApartamento());
//        condominoExistente.setBloco(condominoEsperandoAtualizacao.getBloco());
//        condominoExistente.setEmail(condominoEsperandoAtualizacao.getEmail());
//        condominoExistente.setNomeCompleto(condominoEsperandoAtualizacao.getNomeCompleto());
//        condominoExistente.setTelefone(condominoEsperandoAtualizacao.getTelefone());
//
//        CondominoEntity condominoAtualizado = condominoRepository.save(condominoExistente);
//
//        return condominoAdapter.toDomain(condominoAtualizado);

        CondominoEntity condominoExistente = condominoRepository.findById(condominoEsperandoAtualizacao.getId()).get();
        CondominoEntity condominoAtualizado = condominoAdapter.update(condominoExistente, condominoEsperandoAtualizacao);
        CondominoEntity condominoSalvo = condominoRepository.save(condominoAtualizado);

        return condominoAdapter.toDomain(condominoSalvo);
    }

    @Override
    public List<Condomino> consultarPorFiltros(final String nome, final String cpf, final String bloco, final String apartamento) {
//        List<CondominoEntity> condominos = condominoRepository.findByNomeCompletoContainingIgnoreCaseAndCpfContainingIgnoreCaseAndBlocoContainingIgnoreCaseAndApartamentoContainingIgnoreCase(nome, cpf, bloco, apartamento);
//
//        return condominos.stream().map(condominoAdapter::toDomain).toList();

        return condominoRepository.findByNomeCompletoContainingIgnoreCaseAndCpfContainingIgnoreCaseAndBlocoContainingIgnoreCaseAndApartamentoContainingIgnoreCase(nome, cpf, bloco, apartamento)
            .stream()
            .map(condominoAdapter::toDomain)
            .toList();
    }

}
