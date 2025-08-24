package org.acme.dto.mapper;

import org.acme.dto.ParcelaDTO;
import org.acme.entity.Parcela;

public class ParcelaMapper {
    public static ParcelaDTO toDto(Parcela parcela) {
        return ParcelaDTO.builder()
                .numero(parcela.getNumero())
                .vrAmortizacao(parcela.getVrAmortizacao())
                .vrJuros(parcela.getVrJuros())
                .vrPrestacao(parcela.getVrPrestacao())
                .build();
    }
}
