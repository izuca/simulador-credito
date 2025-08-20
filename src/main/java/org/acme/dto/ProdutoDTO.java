package org.acme.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoDTO {
    @JsonProperty("codigoProduto")
    private int coProduto;

    @JsonProperty("descricaoProduto")
    private String noProduto;
}
