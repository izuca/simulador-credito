package org.acme.dto;

import lombok.*;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "Lista Simulacao Response", description = "DTO para reposta de listagem de simulações")
public class ListaSimulacaoResponseDTO {
    @Schema(description = "Número da página", examples = "1")
    private Integer pagina;

    @Schema(description = "Quantidade de registros totais", examples = "404")
    private Long qtdRegistros;

    @Schema(description = "Quantidade de registros por pagina", examples = "200")
    private Integer qtdRegistrosPagina;

    @Schema(description = "Lista de simulações")
    private List<RegistroDTO> registros;
}
