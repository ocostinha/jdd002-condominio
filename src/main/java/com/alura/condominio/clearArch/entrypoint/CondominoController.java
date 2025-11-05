package com.alura.condominio.clearArch.entrypoint;

import com.alura.condominio.clearArch.business.CondominoBusiness;
import com.alura.condominio.clearArch.domain.Condomino;
import com.alura.condominio.clearArch.entrypoint.adapter.CondominoEntrypointAdapter;
import com.alura.condominio.clearArch.entrypoint.dto.CondominoSaidaDTO;
import com.alura.condominio.clearArch.entrypoint.dto.ContratoEntradaCadastroCondominoDTO;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/condomino")
@AllArgsConstructor
public class CondominoController {

    private CondominoBusiness condominoBusiness;
    private CondominoEntrypointAdapter condominoAdapter;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CondominoSaidaDTO cadastrarCondomino(@Valid @RequestBody ContratoEntradaCadastroCondominoDTO novoCondomino) {
        Condomino condominoConvertido = condominoAdapter.toDomain(novoCondomino);

        Condomino condominoSalvo = condominoBusiness.cadastrarCondomino(condominoConvertido);

        return condominoAdapter.toSaidaDTO(condominoSalvo);
    }

//    @PutMapping("/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public CondominoSaidaDTO atualizarCondomino(@Valid @RequestBody ContratoEntradaAtualizacaoCondominoDTO condomino,
//                                              @PathVariable String id) {
//        Optional<CondominoEntity> condominoExistente = condominoRepository.findById(id);
//
//        if (condominoExistente.isEmpty()) {
//            throw new RecursoNaoEncontradoException("Condomino não encontrado");
//        }
//
//        CondominoEntity condominoAtualizado = condominoAdapter.update(condominoExistente.get(), condomino);
//
//        condominoRepository.save(condominoAtualizado);
//
//        return condominoAtualizado;
//    }
//
//    @GetMapping("/filtros")
//    @ResponseStatus(HttpStatus.OK)
//    public List<CondominoSaidaDTO> consultarCondominoComFiltros(@Nullable @RequestParam("nome") String nome,
//                                                              @Nullable @RequestParam("cpf") String cpf,
//                                                              @Nullable @RequestParam("bloco") String bloco,
//                                                              @Nullable @RequestParam("apartamento") String apartamento) {
//        if ((nome == null || nome.isEmpty()) &&
//            (cpf == null || cpf.isEmpty()) &&
//            (bloco == null || bloco.isEmpty()) &&
//            (apartamento == null || apartamento.isEmpty())) {
//            throw new RegraDeNegocioException("Informe ao menos um dos filtros (nome, cpf, bloco, apartamento) para realizar a consulta");
//        }
//
//        if (nome == null) {
//            nome = "";
//        }
//
//        if (cpf == null) {
//            cpf = "";
//        }
//
//        if (bloco == null) {
//            bloco = "";
//        }
//
//        if (apartamento == null) {
//            apartamento = "";
//        }
//
//        return condominoRepository.findByNomeCompletoContainingIgnoreCaseAndCpfContainingIgnoreCaseAndBlocoContainingIgnoreCaseAndApartamentoContainingIgnoreCase(nome, cpf, bloco, apartamento);
//    }
//
//    @GetMapping
//    @ResponseStatus(HttpStatus.OK)
//    public List<CondominoSaidaDTO> consultarCondomino() {
//        return condominoRepository.findAll();
//    }
//
//    @DeleteMapping("/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void excluirCondomino(@PathVariable String id) {
//        Optional<CondominoEntity> condominoExistente = condominoRepository.findById(id);
//
//        if (condominoExistente.isEmpty()) {
//            throw new RecursoNaoEncontradoException("Condomino não encontrado");
//        }
//
//        condominoRepository.deleteById(id);
//    }

}
