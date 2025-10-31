package com.alura.condominio.controller;

import com.alura.condominio.contratos.ContratoEntradaAtualizacaoCondomino;
import com.alura.condominio.contratos.ContratoEntradaCadastroCondomino;
import com.alura.condominio.database.CondominoEntity;
import com.alura.condominio.database.CondominoRepository;
import com.alura.condominio.infra.RecursoNaoEncontradoException;
import com.alura.condominio.infra.RegraDeNegocioException;
import jakarta.annotation.Nullable;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/condomino")
@AllArgsConstructor
public class CondominoController {

    private CondominoRepository condominoRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CondominoEntity cadastrarCondomino(@Valid @RequestBody ContratoEntradaCadastroCondomino condomino) {
        // Validar que o CPF não existe no banco de dados
        Optional<CondominoEntity> condominoExistente = condominoRepository.findByCpf(condomino.getCpf());

        if (condominoExistente.isPresent()) {
            throw new RegraDeNegocioException("CPF já cadastrado");
        }

        CondominoEntity condominoEntity = new CondominoEntity().fromContratoEntrada(condomino);

        condominoRepository.save(condominoEntity);

        return condominoEntity;
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CondominoEntity atualizarCondomino(@Valid @RequestBody ContratoEntradaAtualizacaoCondomino condomino,
                                              @PathVariable String id) {
        Optional<CondominoEntity> condominoExistente = condominoRepository.findById(id);

        if (condominoExistente.isEmpty()) {
            throw new RecursoNaoEncontradoException("Condomino não encontrado");
        }

        CondominoEntity condominoAtualizado = new CondominoEntity().atualizarCondomino(condominoExistente.get(), condomino);

        condominoRepository.save(condominoAtualizado);

        return condominoAtualizado;
    }

    @GetMapping("/filtros")
    @ResponseStatus(HttpStatus.OK)
    public List<CondominoEntity> consultarCondominoComFiltros(@Nullable @RequestParam("nome") String nome,
                                                              @Nullable @RequestParam("cpf") String cpf,
                                                              @Nullable @RequestParam("bloco") String bloco,
                                                              @Nullable @RequestParam("apartamento") String apartamento) {
        if ((nome == null || nome.isEmpty()) &&
            (cpf == null || cpf.isEmpty()) &&
            (bloco == null || bloco.isEmpty()) &&
            (apartamento == null || apartamento.isEmpty())) {
            throw new RegraDeNegocioException("Informe ao menos um dos filtros (nome, cpf, bloco, apartamento) para realizar a consulta");
        }

        if (nome == null) {
            nome = "";
        }

        if (cpf == null) {
            cpf = "";
        }

        if (bloco == null) {
            bloco = "";
        }

        if (apartamento == null) {
            apartamento = "";
        }

        return condominoRepository.findByNomeCompletoContainingIgnoreCaseAndCpfContainingIgnoreCaseAndBlocoContainingIgnoreCaseAndApartamentoContainingIgnoreCase(nome, cpf, bloco, apartamento);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CondominoEntity> consultarCondomino() {
        return condominoRepository.findAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirCondomino(@PathVariable String id) {
        Optional<CondominoEntity> condominoExistente = condominoRepository.findById(id);

        if (condominoExistente.isEmpty()) {
            throw new RecursoNaoEncontradoException("Condomino não encontrado");
        }

        condominoRepository.deleteById(id);
    }

}
