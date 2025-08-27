package org.acme.dto;

import lombok.*;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(name = "DTO do Endpoint", description = "Métricas do Enpoint")
public class EndpointsDTO {
    @Schema(description = "Nome do Endpoint", examples = "Simulacao")
    private String nomeApi;

    @Schema(description = "Quantidade de Requisições", examples = "135")
    private Long qtdRequisicoes;

    @Schema(description = "Tempo médio de Requisição (Milissegundos)", examples = "150")
    private Integer tempoMedio;

    @Schema(description = "Tempo Máximo de Requisição (Milissegundos)", examples = "860")
    private Integer tempoMaximo;

    @Schema(description = "Taxa de Sucesso", examples = "0.98")
    private Double percentualSucesso;
}
