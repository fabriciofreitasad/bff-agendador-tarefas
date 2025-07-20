package com.targetcar.bffagendadortarefa.business;

import com.targetcar.bffagendadortarefa.business.dto.out.TarefasDTOResponse;
import com.targetcar.bffagendadortarefa.infrastructure.client.EmailClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final EmailClient client;

    public void enviaEmail(TarefasDTOResponse dto) {
        client.enviarEmail(dto);
    }

}
