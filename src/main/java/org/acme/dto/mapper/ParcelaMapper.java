package org.acme.dto.mapper;

import org.acme.dto.ParcelaDTO;
import org.acme.entity.Parcela;

public class ParcelaMapper {
    public static ParcelaDTO toDto(Parcela parcela) {
        ParcelaDTO parcelaDTO = new ParcelaDTO();

        parcelaDTO.setNumero(parcela.getNumero());
        parcelaDTO.setVrAmortizacao(parcela.getVrAmortizacao());
        parcelaDTO.setVrJuros(parcela.getVrJuros());
        parcelaDTO.setVrPrestacao(parcela.getVrPrestacao());

        return parcelaDTO;
    }
}
