package org.acme.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.dto.SimulacaoRequestDTO;
import org.acme.dto.SimulacaoResponseDTO;
import org.acme.dto.mapper.SimulacaoMapper;
import org.acme.entity.Simulacao;
import org.acme.repository.ProdutoRepository;
import org.acme.repository.SimulacaoRepository;

@ApplicationScoped
public class CriaSimulacaoService {
    @Inject
    SimulacaoRepository simulacaoRepository;

    @Inject
    ProdutoRepository produtoRepository;

    public SimulacaoResponseDTO criaSimulacao(SimulacaoRequestDTO simulacaoRequestDTO){
        Simulacao simulacao = SimulacaoMapper.toEntity(simulacaoRequestDTO);
        simulacao.setProduto(produtoRepository.buscaProdCorrespondente(simulacao));
        simulacaoRepository.persist(simulacao);

        return SimulacaoMapper.toResponseDTO(simulacao);
    }
}
