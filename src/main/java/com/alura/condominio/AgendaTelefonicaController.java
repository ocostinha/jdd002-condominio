package com.alura.condominio;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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

import java.util.UUID;

@RestController
@RequestMapping("/agendaTelefonica")
public class AgendaTelefonicaController {

    @Autowired
    private ContatoRepository contatoRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String ola() {
        return "agendaTelefonica";
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<ContatoEntity> cadastrar(@Valid @RequestBody ContratoEntrada contratoEntrada) {
        ContatoEntity contato = new ContatoEntity();

        contato.setNome(contratoEntrada.getNome());
        contato.setCpf(contratoEntrada.getCpf());
        contato.setId(UUID.randomUUID().toString());

        contatoRepository.save(contato);

        return ResponseEntity.ok(contato);
    }

    @PutMapping("/atualizar/{identificador}")
    public ContatoEntity atualizar(@Valid @RequestBody ContratoEntrada contratoEntrada,
                            @PathVariable("identificador") String id) {
        ContatoEntity contato = contatoRepository.findById(id).get();

        contato.setNome(contratoEntrada.getNome());
        contato.setCpf(contratoEntrada.getCpf());

        contatoRepository.save(contato);

        return contato;
    }

    @GetMapping("/buscar")
    public String buscar(@RequestParam("nome") String nome) {
        return nome;
    }

}
