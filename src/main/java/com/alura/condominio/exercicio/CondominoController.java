package com.alura.condominio.exercicio;

import jakarta.validation.Valid;
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

@RestController
@RequestMapping("/condomino")
public class CondominoController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String cadastrarCondomino(@Valid @RequestBody ContratoEntradaCadastroCondomino condomino){
        return "Cadastro efetuado com sucesso";
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String atualizarCondomino(@PathVariable String id,
                                     @Valid @RequestBody ContratoEntradaCadastroCondomino condomino){
        return "Cadastro atualizado com sucesso";
    }

    @GetMapping("/filtros")
    @ResponseStatus(HttpStatus.OK)
    public String buscarCondominoPorCPF(@RequestParam("cpf") String cpf){
        return "Lista de condominos";
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public String buscarTodosCondomino(){
        return "Lista de todos os condominos";
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deletarCondomino(@PathVariable String id){
        return "Condomino deletado com sucesso";
    }

}
