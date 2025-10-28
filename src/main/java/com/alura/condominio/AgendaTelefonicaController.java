package com.alura.condominio;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/agendaTelefonica")
public class AgendaTelefonicaController {

    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String ola() {
        return "agendaTelefonica";
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<String> cadastrar(@Valid @RequestBody ContratoEntrada contratoEntrada) {
        return ResponseEntity.ok(contratoEntrada.getNome());
    }

    @PutMapping("/atualizar/{identificador}")
    public String atualizar(@Valid @RequestBody ContratoEntrada contratoEntrada,
                            @PathVariable("identificador") String id) {
        return id;
    }

    @GetMapping("/buscar")
    public String buscar(@RequestParam("nome") String nome) {
        return nome;
    }

}
