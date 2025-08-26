package org.acme.dto;

import lombok.*;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "Volume Simulado Response", description = "DTO de resposta do volume simulado")
public class VolumeSimuladoResponseDTO {
    @Schema(description = "Data de Referência", examples = "2025-07-30")
    private LocalDate dataReferencia;

    @Schema(description = "Simulacoes por Produto")
    List<VolumeSimuladoProdutoDTO> simulacoes;
}
