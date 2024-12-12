package com.rdaltio.agendadortarefas.business.mapper;

import com.rdaltio.agendadortarefas.business.dto.TarefasDTO;
import com.rdaltio.agendadortarefas.infrastructure.entity.TarefasEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TarefasConverter {

    TarefasEntity paraTarefasEntity(TarefasDTO dto);
    TarefasDTO paraTarefasDTO(TarefasEntity entity);
}
