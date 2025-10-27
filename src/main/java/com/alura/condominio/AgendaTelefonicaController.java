package com.alura.condominio;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @GetMapping("/lista/xpto")
    public String listaXpto() {
        return "listaXpto";
    }

}
