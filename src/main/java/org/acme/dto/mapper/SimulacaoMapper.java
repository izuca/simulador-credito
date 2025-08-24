package org.acme.dto.mapper;

import org.acme.dto.ParcelaDTO;
import org.acme.dto.ResultadoSimulacaoDTO;
import org.acme.dto.SimulacaoRequestDTO;
import org.acme.dto.SimulacaoResponseDTO;
import org.acme.entity.Simulacao;

import java.util.ArrayList;
import java.util.List;


public class SimulacaoMapper {
    public static Simulacao toEntity(SimulacaoRequestDTO simulacaoRequestDTO){
        return Simulacao.builder()
                .prazo(simulacaoRequestDTO.getPrazo())
                .valorDesejado(simulacaoRequestDTO.getValorDesejado())
                .produto(null)
                .parcelas(new ArrayList<>())
                .build();
    }

    public static SimulacaoResponseDTO toResponseDTO(Simulacao simulacao, List<ParcelaDTO> parcelasSAC, List<ParcelaDTO> parcelasPRICE){
        List<ResultadoSimulacaoDTO> resultadoSimulacaoDTOList = new ArrayList<>();

        ResultadoSimulacaoDTO resultadoSAC = ResultadoSimulacaoDTO.builder()
                .tipo("SAC")
                .parcelas(parcelasSAC)
                .build();
        resultadoSimulacaoDTOList.add(resultadoSAC);

        ResultadoSimulacaoDTO resultadoPRICE = ResultadoSimulacaoDTO.builder()
                .tipo("PRICE")
                .parcelas(parcelasPRICE)
                .build();
        resultadoSimulacaoDTOList.add(resultadoPRICE);

        return SimulacaoResponseDTO.builder()
                .idSimulacao(simulacao.getIdSimulacao())
                .produtoId(simulacao.getProduto().getCoProduto())
                .noProduto(simulacao.getProduto().getNoProduto())
                .pcTaxaJuros(simulacao.getProduto().getPcTaxaJuros())
                .resultadoSimulacaoDTOList(resultadoSimulacaoDTOList)
                .build();
    }
}
