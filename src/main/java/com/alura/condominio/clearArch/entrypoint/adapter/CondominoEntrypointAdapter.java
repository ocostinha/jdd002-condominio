package com.alura.condominio.clearArch.entrypoint.adapter;

import com.alura.condominio.clearArch.domain.Condomino;
import com.alura.condominio.clearArch.entrypoint.dto.CondominoSaidaDTO;
import com.alura.condominio.clearArch.entrypoint.dto.ContratoEntradaCadastroCondominoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(imports = java.util.UUID.class, componentModel = "spring")
public interface CondominoEntrypointAdapter {

    @Mapping(target = "id", expression = "java(java.util.UUID.randomUUID().toString())")
    Condomino toDomain(ContratoEntradaCadastroCondominoDTO contratoEntrada);

    CondominoSaidaDTO toSaidaDTO(Condomino condomino);

}
