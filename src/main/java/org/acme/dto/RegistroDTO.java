package org.acme.dto;

import lombok.*;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "Registro", description = "Registro de simulação realizada")
public class RegistroDTO {
    @Schema(description = "Id da simulação", examples = "20180702")
    private Long idSimulacao;


    @Schema(description = "Valor simulado", examples = "900.00")
    private BigDecimal valorDesejado;

    @Schema(description = "Prazo",examples = "5")
    private Integer prazo;

    @Schema(description = "Valor total das parcelas SAC", examples = "1243.28")
    private BigDecimal valorTotalParcelasSAC;

    @Schema(description = "Valor total das parcelas Price", examples = "1254.48")
    private BigDecimal valorTotalParcelasPrice;
}
