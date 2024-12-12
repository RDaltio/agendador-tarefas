package com.rdaltio.agendadortarefas.business;

import com.rdaltio.agendadortarefas.business.dto.TarefasDTO;
import com.rdaltio.agendadortarefas.business.mapper.TarefasConverter;
import com.rdaltio.agendadortarefas.infrastructure.entity.TarefasEntity;
import com.rdaltio.agendadortarefas.infrastructure.enums.StatusNotificacaoEnum;
import com.rdaltio.agendadortarefas.infrastructure.repository.TarefasRepository;
import com.rdaltio.agendadortarefas.infrastructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TarefasService {
    private final TarefasRepository tarefasRepository;
    private final TarefasConverter tarefasConverter;
    private final JwtUtil jwtUtil;

    public TarefasDTO gravarTarefa(String token, TarefasDTO dto){
        String email = jwtUtil.extractUsername(token.substring(7));
        dto.setEmailUsuario(email);
        dto.setDataCriacao(LocalDateTime.now());
        dto.setStatusNotificacaoEnum(StatusNotificacaoEnum.PENDENTE);
        TarefasEntity entity = tarefasConverter.paraTarefasEntity(dto);

        return tarefasConverter.paraTarefasDTO(
                tarefasRepository.save(entity)
        );
    }
}