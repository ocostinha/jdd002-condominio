package com.alura.condominio.clearArch.service.impl;

import com.alura.condominio.clearArch.domain.Condomino;
import com.alura.condominio.clearArch.service.CondominoService;
import com.alura.condominio.clearArch.service.adapter.CondominoServiceAdapter;
import com.alura.condominio.clearArch.service.repository.CondominoRepository;
import com.alura.condominio.clearArch.service.repository.entity.CondominoEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
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

}
