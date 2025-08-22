package org.acme.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Schema(name = "Simulacao Response", description = "DTO de resposta para simulação")
public class SimulacaoResponseDTO {
    @Schema(description = "ID da simulação", examples = "1")
    private Long idSimulacao;

    @Schema(description = "Código do Produto Selecionado para Simulacao", examples = "1")
    @JsonProperty("codigoProduto")
    private Long produtoId;

    @Schema(description = "Nome do Produto Selecionado para Simulacao", examples = "Produto 1")
    @JsonProperty("descricaoProduto")
    private String noProduto;

    @Schema(description = "Taxa de Juros do Produto", examples = "0.015")
    @JsonProperty("taxaJuros")
    private BigDecimal pcTaxaJuros;

    @Schema(description = "Lista de resultados")
    @JsonProperty("resultadoSimulacao")
    private List<ResultadoSimulacaoDTO> resultadoSimulacaoDTOList;

}
