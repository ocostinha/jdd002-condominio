package com.alura.condominio.adapter;

import com.alura.condominio.contratos.ContratoEntradaAtualizacaoCondomino;
import com.alura.condominio.contratos.ContratoEntradaCadastroCondomino;
import com.alura.condominio.database.CondominoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", imports = {java.util.UUID.class})
public interface CondominoAdapter {

    @Mapping(target = "id", expression = "java(UUID.randomUUID().toString())")
    CondominoEntity toEntity(ContratoEntradaCadastroCondomino contratoEntrada);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "cpf", ignore = true)
    CondominoEntity update(@MappingTarget CondominoEntity condominoEntity, ContratoEntradaAtualizacaoCondomino contratoEntrada);

}
