package org.acme.dto.mapper;

import org.acme.dto.SimulacaoRequestDTO;
import org.acme.dto.SimulacaoResponseDTO;
import org.acme.entity.Simulacao;


public class SimulacaoMapper {
    public static Simulacao toEntity(SimulacaoRequestDTO simulacaoRequestDTO){
        Simulacao simulacao = new Simulacao();

        simulacao.setPrazo(simulacaoRequestDTO.getPrazo());
        simulacao.setValorDesejado(simulacaoRequestDTO.getValorDesejado());

        return simulacao;
    }

    public static SimulacaoResponseDTO toResponseDTO(Simulacao simulacao){
        SimulacaoResponseDTO simulacaoResponseDTO = new SimulacaoResponseDTO();

        simulacaoResponseDTO.setIdSimulacao(simulacao.getIdSimulacao());
        simulacaoResponseDTO.setProdutoId(simulacao.getProduto().getCoProduto());
        simulacaoResponseDTO.setNoProduto(simulacao.getProduto().getNoProduto());
        simulacaoResponseDTO.setPcTaxaJuros(simulacao.getProduto().getPcTaxaJuros());
        simulacaoResponseDTO.setResultadoSimulacaoDTOList(simulacao.getParcelas());//editar

        return simulacaoResponseDTO;
    }
}
