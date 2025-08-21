package org.acme.dto;


import org.eclipse.microprofile.openapi.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(name = "Produto Response",description = "Produto DTO")
public class ProdutoDTO {
    @JsonProperty("codigoProduto")
    @Schema( description = "Código do Produto", example = "12345")
    private Long coProduto;

    @Schema( description = "Nome do Produto", example = "Produto 1")
    @JsonProperty("descricaoProduto")
    private String noProduto;
}
