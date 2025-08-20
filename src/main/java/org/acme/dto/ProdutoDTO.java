package org.acme.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoDTO {
    @JsonProperty("codigoProduto")
    private Long coProduto;

    @JsonProperty("descricaoProduto")
    private String noProduto;
}
