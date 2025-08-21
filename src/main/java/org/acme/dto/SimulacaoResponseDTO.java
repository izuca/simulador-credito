package org.acme.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Schema(name = "Simulacao Response", description = "DTO de resposta para simulação")
public class SimulacaoResponseDTO {
    @Schema(description = "ID da simulação", example = "1")
    private Long idSimulacao;

    @Schema(description = "Código do Produto Selecionado para Simulacao", example = "1")
    @JsonProperty("codigoProduto")
    private Long produtoId;

    @Schema(description = "Nome do Produto Selecionado para Simulacao", example = "Produto 1")
    @JsonProperty("descricaoProduto")
    private String noProduto;

    @Schema(description = "Taxa de Juros do Produto", example = "0.015")
    @JsonProperty("taxaJuros")
    private BigDecimal pcTaxaJuros;

    @Schema(description = "Data da Simulação", example = "2023-10-01T12:00:00")
    @JsonProperty("dataCriacao")
    private LocalDateTime dataHora;

}
