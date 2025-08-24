package org.acme.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(name = "Cria Simulacao Response", description = "DTO de resposta para criação de simulação")
public class CriaSimulacaoResponseDTO {
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
    @JsonProperty("resultadosSimulacao")
    private List<ResultadoSimulacaoDTO> resultadoSimulacaoDTOList;

}
