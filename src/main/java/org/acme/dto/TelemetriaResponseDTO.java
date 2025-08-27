package org.acme.dto;

import lombok.*;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(name="Response de Telemetria", description = "Retorna telemetria por data de referência")
public class TelemetriaResponseDTO {
    private LocalDate dataReferencia;
    List<EndpointsDTO> listaEndpoints;
}
