package org.acme.services;


import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.panache.common.Page;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.dto.ListaSimulacaoResponseDTO;
import org.acme.dto.mapper.SimulacaoMapper;
import org.acme.entity.Simulacao;
import org.acme.repository.SimulacaoRepository;

import java.util.stream.Collectors;

@ApplicationScoped
public class ListaSimulacaoService {
    @Inject
    SimulacaoRepository simulacaoRepository;

    public ListaSimulacaoResponseDTO listarSimulacoes(int pagina, int qtdRegistrosPagina){
        PanacheQuery<Simulacao> query = simulacaoRepository.findAll().page(Page.of(pagina - 1, qtdRegistrosPagina));

        return ListaSimulacaoResponseDTO.builder()
                .pagina(pagina)
                .qtdRegistros(query.count())
                .qtdRegistrosPagina(qtdRegistrosPagina)
                .registros(query.list().stream()
                        .map(SimulacaoMapper::toRegistro)
                        .collect(Collectors.toList()))
                .build();
    }
}
