package org.acme.dto;


import lombok.*;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonProperty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(name = "Produto Response",description = "Produto DTO")
public class ProdutoDTO {
    @JsonProperty("codigoProduto")
    @Schema( description = "Código do Produto", example = "12345")
    private Long coProduto;

    @Schema( description = "Nome do Produto", example = "Produto 1")
    @JsonProperty("descricaoProduto")
    private String noProduto;
}
