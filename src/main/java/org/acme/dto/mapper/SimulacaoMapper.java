package org.acme.dto.mapper;

import org.acme.dto.*;
import org.acme.entity.Parcela;
import org.acme.entity.Simulacao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class SimulacaoMapper {
    public static Simulacao toEntity(CriaSimulacaoRequestDTO criaSimulacaoRequestDTO){
        return Simulacao.builder()
                .prazo(criaSimulacaoRequestDTO.getPrazo())
                .valorDesejado(criaSimulacaoRequestDTO.getValorDesejado())
                .produto(null)
                .parcelas(new ArrayList<>())
                .build();
    }

    public static CriaSimulacaoResponseDTO toResponseDTO(Simulacao simulacao, List<ParcelaDTO> parcelasSAC, List<ParcelaDTO> parcelasPRICE){
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

        return CriaSimulacaoResponseDTO.builder()
                .idSimulacao(simulacao.getIdSimulacao())
                .produtoId(simulacao.getProduto().getCoProduto())
                .noProduto(simulacao.getProduto().getNoProduto())
                .pcTaxaJuros(simulacao.getProduto().getPcTaxaJuros())
                .resultadoSimulacaoDTOList(resultadoSimulacaoDTOList)
                .build();
    }

    public static RegistroDTO toRegistro(Simulacao simulacao) {
        return RegistroDTO.builder()
                .idSimulacao(simulacao.getIdSimulacao())
                .valorDesejado(simulacao.getValorDesejado())
                .prazo(simulacao.getPrazo())
                .valorTotalParcelasSAC(simulacao.getParcelas().stream()
                        .filter(p ->"SAC".equals(p.getTipo()))
                        .map(Parcela::getVrPrestacao)
                        .reduce(BigDecimal.ZERO,BigDecimal::add)
                )
                .valorTotalParcelasPrice(simulacao.getParcelas().stream()
                        .filter(p ->"PRICE".equals(p.getTipo()))
                        .map(Parcela::getVrPrestacao)
                        .reduce(BigDecimal.ZERO,BigDecimal::add))
                .build();
    }
}
