package org.acme.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.dto.ParcelaDTO;
import org.acme.dto.CriaSimulacaoRequestDTO;
import org.acme.dto.CriaSimulacaoResponseDTO;
import org.acme.dto.mapper.ParcelaMapper;
import org.acme.dto.mapper.SimulacaoMapper;
import org.acme.entity.Parcela;
import org.acme.entity.Simulacao;
import org.acme.exception.ProdutoIncompativelException;
import org.acme.repository.ProdutoRepository;
import org.acme.repository.SimulacaoRepository;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class CriaSimulacaoService {
    @Inject
    SimulacaoRepository simulacaoRepository;

    @Inject
    ProdutoRepository produtoRepository;

    @Inject
    ParcelaService parcelaService;

    public CriaSimulacaoResponseDTO criaSimulacao(CriaSimulacaoRequestDTO criaSimulacaoRequestDTO){
        Simulacao simulacao = SimulacaoMapper.toEntity(criaSimulacaoRequestDTO);
        simulacao.setProduto(produtoRepository.buscaProdCorrespondente(simulacao));
        if(simulacao.getProduto() == null){
            throw new ProdutoIncompativelException("Esta Simulação não possui produto compativel");
        }

        List<Parcela> parcelasSAC = (parcelaService.calculaSAC(simulacao));
        List<Parcela> parcelaPRICE = (parcelaService.calculaPrice(simulacao));
        simulacaoRepository.persist(simulacao);

        List<ParcelaDTO> listaPacSac = parcelasSAC.stream()
                .map(ParcelaMapper::toDto)
                .collect(Collectors.toList());
        List<ParcelaDTO> listaPacPrice = parcelaPRICE.stream()
                .map(ParcelaMapper::toDto)
                .collect(Collectors.toList());
        return SimulacaoMapper.toResponseDTO(simulacao,listaPacSac, listaPacPrice);
    }
}
