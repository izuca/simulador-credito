package org.acme.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class SimulacaoResponseDTO {

    private Long idSimulacao;

    @JsonProperty("codigoProduto")
    private Long produtoId;

    @JsonProperty("descricaoProduto")
    private String noProduto;

    @JsonProperty("taxaJuros")
    private BigDecimal pcTaxaJuros;

    @JsonProperty("dataCriacao")
    private LocalDateTime dataHora;

}
