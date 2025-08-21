package org.acme.dto;

import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Getter
@Setter
@Schema(name = "Simulacao Request", description = "DTO para requisição de simulação de empréstimo")
public class SimulacaoRequestDTO {
    @Schema(description = "Valor desejado para o empréstimo", example = "10000.00", required = true)
    private BigDecimal valorDesejado;

    @Schema(description = "Prazo em meses para pagamento do empréstimo", example = "24", required = true)
    private Integer prazo;
}
