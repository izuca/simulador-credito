package org.acme.dto;

import lombok.*;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(name = "Erro Response", description = "Mensagem de Erro Padrão")
public class ErrorResponseDTO {
    @Schema(description = "Código HTTP do Erro", example = "400")
    private int codigoHttp;

    @Schema(description = "Mensagem de Erro", example = "Parâmetro X não pode ser nulo")
    private String mensagem;

}