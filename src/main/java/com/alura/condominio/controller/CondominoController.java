package com.alura.condominio.controller;

import com.alura.condominio.contratos.ContratoEntradaCadastroCondomino;
import com.alura.condominio.database.CondominoEntity;
import com.alura.condominio.database.CondominoRepository;
import com.alura.condominio.infra.RegraDeNegocioException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/condomino")
public class CondominoController {

    @Autowired
    private CondominoRepository condominoRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CondominoEntity cadastrarCondomino(@Valid @RequestBody ContratoEntradaCadastroCondomino condomino) {
        // Validar que o CPF não existe no banco de dados
        Optional<CondominoEntity> condominoExistente = condominoRepository.findByCpf(condomino.getCpf());

        if (condominoExistente.isPresent()) {
            throw new RegraDeNegocioException("CPF já cadastrado");
        }

        CondominoEntity condominoEntity = new CondominoEntity();

        condominoEntity.setId(UUID.randomUUID().toString());
        condominoEntity.setNomeCompleto(condomino.getNomeCompleto());
        condominoEntity.setCpf(condomino.getCpf());
        condominoEntity.setEmail(condomino.getEmail());
        condominoEntity.setTelefone(condomino.getTelefone());
        condominoEntity.setBloco(condomino.getBloco());
        condominoEntity.setApartamento(condomino.getApartamento());

        condominoRepository.save(condominoEntity);

        return condominoEntity;
    }

}
