package org.acme.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;
import java.math.BigDecimal;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "Simulacao Request", description = "DTO para requisição de simulação de empréstimo")
public class SimulacaoRequestDTO {
    @NotNull(message = "Valor desejado é obrigatório")
    @DecimalMin(value = "0.01", message = "Valor desejado deve ser maior que zero")
    @Schema(description = "Valor desejado para o empréstimo", example = "10000.00", required = true)
    private BigDecimal valorDesejado;

    @NotNull(message = "Prazo é obrigatório")
    @Positive(message = "Prazo deve ser maior que zero")
    @Schema(description = "Prazo em meses para pagamento do empréstimo", example = "24", required = true)
    private Integer prazo;
}
