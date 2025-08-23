package org.acme.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.dto.ParcelaDTO;
import org.acme.dto.SimulacaoRequestDTO;
import org.acme.dto.SimulacaoResponseDTO;
import org.acme.dto.mapper.ParcelaMapper;
import org.acme.dto.mapper.SimulacaoMapper;
import org.acme.entity.Parcela;
import org.acme.entity.Simulacao;
import org.acme.repository.ProdutoRepository;
import org.acme.repository.SimulacaoRepository;
import org.acme.exception.ParametroNuloException;

import java.math.BigDecimal;
import java.util.List;

@ApplicationScoped
public class CriaSimulacaoService {
    @Inject
    SimulacaoRepository simulacaoRepository;

    @Inject
    ProdutoRepository produtoRepository;

    @Inject
    ParcelaService parcelaService;

    public SimulacaoResponseDTO criaSimulacao(SimulacaoRequestDTO simulacaoRequestDTO){
        if (simulacaoRequestDTO.getPrazo() == 0){
            throw new ParametroNuloException("Prazo não pode ser zero");
        } else if (simulacaoRequestDTO.getValorDesejado().compareTo(BigDecimal.ZERO) == 0){
            throw new ParametroNuloException("Valor desejado não pode ser zero");
        }
        Simulacao simulacao = SimulacaoMapper.toEntity(simulacaoRequestDTO);
        simulacao.setProduto(produtoRepository.buscaProdCorrespondente(simulacao));

        List<Parcela> parcelasSAC = (parcelaService.calculaSAC(simulacao));
        List<Parcela> parcelaPRICE = (parcelaService.calculaPrice(simulacao));
        simulacaoRepository.persist(simulacao);

        List<ParcelaDTO> listaPacSac = ParcelaMapper.toDto(parcelasSAC);
        List<ParcelaDTO> listaPacPrice = ParcelaMapper.toDto(parcelaPRICE);
        return SimulacaoMapper.toResponseDTO(simulacao,listaPacSac, listaPacPrice);
    }
}
