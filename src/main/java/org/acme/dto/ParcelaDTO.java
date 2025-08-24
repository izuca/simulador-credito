package org.acme.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "Parcela DTO")
public class ParcelaDTO {
    @Schema(description = "Numero da Parcela", example = "2")
    private Integer numero;

    @JsonProperty("valorAmortizacao")
    @Schema(description = "Valor da Amortizacao", example = "1400.00")
    private BigDecimal vrAmortizacao;

    @JsonProperty("valorJuros")
    @Schema(description = "Valor dos Juros", example = "9.67")
    private BigDecimal vrJuros;

    @JsonProperty("valorPrestacao")
    @Schema(description = "Valor da Prestacao", example = "1409.67")
    private BigDecimal vrPrestacao;
}
