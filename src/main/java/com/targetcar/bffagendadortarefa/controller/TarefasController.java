package com.targetcar.bffagendadortarefa.controller;


import com.targetcar.bffagendadortarefa.business.TarefaService;
import com.targetcar.bffagendadortarefa.business.dto.in.TarefasDTORequest;
import com.targetcar.bffagendadortarefa.business.dto.out.TarefasDTOResponse;
import com.targetcar.bffagendadortarefa.business.enums.StatusNotificacaoEnum;
import com.targetcar.bffagendadortarefa.infrastructure.security.SecurityConfig;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/tarefas")
@RequiredArgsConstructor
@Tag(name = "Tarefas", description = "Cadastro tarefas de usuarios")
@SecurityRequirement(name = SecurityConfig.SECURITY_SCHEME)
public class TarefasController {

    private final TarefaService tarefaService;

    @PostMapping
    @Operation(summary = "Salvar tarefas de Usuario", description = "Cria um novo Tarefa")
    @ApiResponse(responseCode = "200", description = "Tarefa salva com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro de servidos")
    public ResponseEntity<TarefasDTOResponse> gravarTarefas(@RequestHeader(value = "Authorization", required = false) String token,
                                                            @RequestBody TarefasDTORequest dto) {
        return ResponseEntity.ok(tarefaService.gravarTarefas(token, dto));
    }

    @GetMapping("/eventos")
    @Operation(summary = "Busca tarefas por período",
            description = "Bussca tarefas cadastradas por período")
    @ApiResponse(responseCode = "200", description = "Tarefa encontrada")
    @ApiResponse(responseCode = "500", description = "Erro de servidos")
    public ResponseEntity<List<TarefasDTOResponse>> buscarListaDeTarefasporPeriodo(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicial,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFinal,
            @RequestHeader(name = "Authorization", required = false) String token) {
        return ResponseEntity.ok(tarefaService.buscartarefasAgendadosPorPeriodo(dataInicial, dataFinal, token));
    }

    @GetMapping
    @Operation(summary = "Busca lista tarefas por email de Usuário",
            description = "Bussca tarefas cadastradas por Usuário")
    @ApiResponse(responseCode = "200", description = "Tarefa encontrada")
    @ApiResponse(responseCode = "500", description = "Erro de servidos")
    public ResponseEntity<List<TarefasDTOResponse>> buscarTarefasPorEmail(@RequestHeader(name = "Authorization", required = false) String token) {
        return ResponseEntity.ok(tarefaService.buscarTarefasPorEmail(token));
    }

    @DeleteMapping
    @Operation(summary = "Deleta tarefas por Id",
            description = "Deleta tarefas cadastradas por ID")
    @ApiResponse(responseCode = "200", description = "Tarefa deletada")
    @ApiResponse(responseCode = "500", description = "Erro de servidos")
    public ResponseEntity<Void> deletaTarefaPorId(@RequestParam("id") String id,
                                                  @RequestHeader(name = "Authorization", required = false) String token) {
        tarefaService.deletaTarefaPorId(id, token);
        return ResponseEntity.ok().build();
    }

    @PatchMapping
    @Operation(summary = "Altera status de tarefas",
            description = "Altera status de tarefas cadastradas")
    @ApiResponse(responseCode = "200", description = "Status da tarefa alterada")
    @ApiResponse(responseCode = "500", description = "Erro de servidos")
    public ResponseEntity<TarefasDTOResponse> alteraStatusNotificacao(@RequestParam("status") StatusNotificacaoEnum status,
                                                                      @RequestParam("id") String id,
                                                                      @RequestHeader(name = "Authorization", required = false) String token) {
        return ResponseEntity.ok(tarefaService.alterarStatus(status, id, token));
    }

    @PutMapping
    @Operation(summary = "Altera dados de tarefas",
            description = "Altera dados de tarefa cadastrada")
    @ApiResponse(responseCode = "200", description = "Tarefa encontrada")
    @ApiResponse(responseCode = "500", description = "Erro de servidos")
    public ResponseEntity<TarefasDTOResponse> updatetarefas(@RequestBody TarefasDTORequest dto,
                                                            @RequestParam("id") String id,
                                                            @RequestHeader(name = "Authorization", required = false) String token) {
        return ResponseEntity.ok(tarefaService.updatetarefas(dto, id, token));
    }
}
