package org.acme.dto.mapper;

import org.acme.dto.ParcelaDTO;
import org.acme.entity.Parcela;

import java.util.ArrayList;
import java.util.List;

public class ParcelaMapper {
    public static List<ParcelaDTO> toDto(List<Parcela> parcelaList) {
        List<ParcelaDTO> parcelaDTOList= new ArrayList<>();

        for (Parcela parcela : parcelaList) {
            ParcelaDTO parcelaDTO = new ParcelaDTO();

            parcelaDTO.setNumero(parcela.getNumero());
            parcelaDTO.setVrAmortizacao(parcela.getVrAmortizacao());
            parcelaDTO.setVrJuros(parcela.getVrJuros());
            parcelaDTO.setVrPrestacao(parcela.getVrPrestacao());

            parcelaDTOList.add(parcelaDTO);
        }


        return parcelaDTOList;
    }
}
