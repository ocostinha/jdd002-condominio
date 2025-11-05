package com.alura.condominio.clearArch.service.adapter;

import com.alura.condominio.clearArch.domain.Condomino;
import com.alura.condominio.clearArch.service.repository.entity.CondominoEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CondominoServiceAdapter {

    CondominoEntity toEntity(Condomino domain);

    Condomino toDomain(CondominoEntity entity);

}
