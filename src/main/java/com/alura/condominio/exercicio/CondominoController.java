package com.alura.condominio.exercicio;

import com.alura.condominio.RecursoNaoEncontratoException;
import jakarta.validation.Valid;
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
import java.util.UUID;

@RestController
@RequestMapping("/condomino")
public class CondominoController {

    @Autowired
    private CondominoRepository condominoRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CondominoEntity cadastrarCondomino(@Valid @RequestBody ContratoEntradaCadastroCondomino condomino){
        CondominoEntity condominoEntity = new CondominoEntity();

        condominoEntity.setApartamento(condomino.getApartamento());
        condominoEntity.setBloco(condomino.getBloco());
        condominoEntity.setCpf(condomino.getCpf());
        condominoEntity.setEmail(condomino.getEmail());
        condominoEntity.setNome(condomino.getNome());
        condominoEntity.setNumeroCelular(condomino.getNumeroCelular());
        condominoEntity.setDddCelular(condomino.getDddCelular());
        condominoEntity.setId(UUID.randomUUID().toString());

        condominoRepository.save(condominoEntity);

        return condominoEntity;
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CondominoEntity atualizarCondomino(@PathVariable String id,
                                     @Valid @RequestBody ContratoEntradaCadastroCondomino condomino){
        CondominoEntity condominoEntity = condominoRepository.findById(id)
            .orElseThrow(() -> new RecursoNaoEncontratoException("Contato não encontrado"));

        condominoEntity.setApartamento(condomino.getApartamento());
        condominoEntity.setBloco(condomino.getBloco());
        condominoEntity.setCpf(condomino.getCpf());
        condominoEntity.setEmail(condomino.getEmail());
        condominoEntity.setNome(condomino.getNome());
        condominoEntity.setNumeroCelular(condomino.getNumeroCelular());
        condominoEntity.setDddCelular(condomino.getDddCelular());

        condominoRepository.save(condominoEntity);

        return condominoEntity;
    }

    @GetMapping("/filtros")
    @ResponseStatus(HttpStatus.OK)
    public CondominoEntity buscarCondominoPorCPF(@RequestParam("cpf") String cpf){
        return condominoRepository.findByCpf(cpf)
            .orElseThrow(() -> new RecursoNaoEncontratoException("Contato não encontrado"));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CondominoEntity> buscarTodosCondomino(){
        return condominoRepository.findAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletarCondomino(@PathVariable String id){
        condominoRepository.deleteById(id);
    }

}
