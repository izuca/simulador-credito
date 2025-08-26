package org.acme.dto;

import lombok.*;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "Volume por Produto Simulado", description = "DTO de dados de volumetria por Produto Simulado")
public class VolumeSimuladoProdutoDTO {
    @Schema(description = "Código do produto",examples = "1")
    private Long codigoProduto;

    @Schema(description = "Nome do produto",examples = "Produto 1")
    private String descricaoProduto;

    @Schema(description = "Taxa média de juros", examples ="0.189")
    private BigDecimal taxaMediaJuro;

    @Schema(description = "Valor Médio da Prestação", examples = "300.00")
    private BigDecimal valorMedioPrestacao;

    @Schema(description = "Valor Total Desejado", examples = "12047.47")
    private BigDecimal valorTotalDesejado;

    @Schema(description = "Valor Total do Crédito Price", examples = "16750.00")
    private BigDecimal valorTotalCreditoPrice;

    @Schema(description = "Valor Total do Crédito SAC", examples = "17760.00")
    private BigDecimal valorTotalCreditoSAC;
}
