package com.targetcar.bffagendadortarefa.business;

import com.targetcar.bffagendadortarefa.business.dto.in.TarefasDTORequest;
import com.targetcar.bffagendadortarefa.business.dto.out.TarefasDTOResponse;
import com.targetcar.bffagendadortarefa.business.enums.StatusNotificacaoEnum;
import com.targetcar.bffagendadortarefa.infrastructure.client.TarefasClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TarefaService {

    private final TarefasClient client;

    public TarefasDTOResponse gravarTarefas(String token, TarefasDTORequest dto) {
        return client.gravarTarefas(token, dto);
    }

    public List<TarefasDTOResponse> buscartarefasAgendadosPorPeriodo(LocalDateTime dataInicial,
                                                                     LocalDateTime dataFinal,
                                                                     String token) {
        return client.buscarListaDeTarefasporPeriodo(dataInicial, dataFinal, token);
    }

    public List<TarefasDTOResponse> buscarTarefasPorEmail(String token) {
        return client.buscarTarefasPorEmail(token);
    }

    public void deletaTarefaPorId(String id, String token) {
       client.deletaTarefaPorId(id,token);
    }

    public TarefasDTOResponse alterarStatus(StatusNotificacaoEnum status, String id, String token) {
        return client.alteraStatusNotificacao(status, id, token);
    }

    public TarefasDTOResponse updatetarefas(TarefasDTORequest dto, String id, String token) {
        return client.updatetarefas(dto, id, token);
    }
}
