package org.acme.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class SimulacaoRequestDTO {
    private BigDecimal valorDesejado;
    private Integer prazo;
}
