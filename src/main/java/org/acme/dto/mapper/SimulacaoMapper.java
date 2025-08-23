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
        Simulacao simulacao = new Simulacao();

        simulacao.setPrazo(simulacaoRequestDTO.getPrazo());
        simulacao.setValorDesejado(simulacaoRequestDTO.getValorDesejado());

        return simulacao;
    }

    public static SimulacaoResponseDTO toResponseDTO(Simulacao simulacao, List<ParcelaDTO> parcelasSAC){
        SimulacaoResponseDTO simulacaoResponseDTO = new SimulacaoResponseDTO();
        List<ResultadoSimulacaoDTO> resultadoSimulacaoDTOList = new ArrayList<>();

        ResultadoSimulacaoDTO resultadoSAC = new ResultadoSimulacaoDTO();
        resultadoSAC.setTipo("SAC");
        resultadoSAC.setParcelas(parcelasSAC);
        resultadoSimulacaoDTOList.add(resultadoSAC);

        simulacaoResponseDTO.setIdSimulacao(simulacao.getIdSimulacao());
        simulacaoResponseDTO.setProdutoId(simulacao.getProduto().getCoProduto());
        simulacaoResponseDTO.setNoProduto(simulacao.getProduto().getNoProduto());
        simulacaoResponseDTO.setPcTaxaJuros(simulacao.getProduto().getPcTaxaJuros());
        simulacaoResponseDTO.setResultadoSimulacaoDTOList(resultadoSimulacaoDTOList);

        return simulacaoResponseDTO;
    }
}
