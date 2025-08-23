package org.acme.dto;

import lombok.Getter;
import lombok.Setter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.util.List;

@Getter
@Setter
@Schema(name = "Resultado Simulacao DTO", description = "DTO de resultado da simulacao")
public class ResultadoSimulacaoDTO {
    @Schema(description = "Tipo de Amortização", examples = "SAC")
    private String tipo;

    private List<ParcelaDTO> parcelas;
}
