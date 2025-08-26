package org.acme.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.WebApplicationException;
import org.acme.dto.VolumeSimuladoProdutoDTO;
import org.acme.dto.VolumeSimuladoResponseDTO;
import org.acme.dto.mapper.SimulacaoMapper;
import org.acme.entity.Parcela;
import org.acme.entity.Simulacao;
import org.acme.repository.SimulacaoRepository;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ApplicationScoped
public class VolumeSimuladoService {
    @Inject
    SimulacaoRepository simulacaoRepository;

    public VolumeSimuladoResponseDTO listarVolumeProduto(String dataReferencia) {
        LocalDate data;
        try {
            data = LocalDate.parse(dataReferencia);
        } catch (DateTimeParseException e){
            throw new WebApplicationException("Data invalida. Use o formato yyyy-MM-dd.", 400);
        }

        List<Simulacao> simulacaoList = simulacaoRepository.buscarPorData(data);

        Map<Long, VolumeSimuladoProdutoDTO> volumePorProduto = simulacaoList.stream()
                .collect(Collectors.groupingBy(s -> s.getProduto().getCoProduto(), Collectors.collectingAndThen(
                        Collectors.toList(), simulacoes -> {
                           BigDecimal somaValorDesejado = simulacoes.stream()
                                   .map(Simulacao::getValorDesejado)
                                   .reduce(BigDecimal.ZERO, BigDecimal::add);

                           List<BigDecimal> valoresParcelas = simulacoes.stream()
                                   .flatMap(s -> s.getParcelas().stream().map(Parcela::getVrPrestacao))
                                   .toList();

                           BigDecimal somaPrestacoes = valoresParcelas.stream()
                                   .reduce(BigDecimal.ZERO, BigDecimal::add);

                            BigDecimal mediaPrestacoes = valoresParcelas.isEmpty()
                                    ? BigDecimal.ZERO
                                    :somaPrestacoes.divide(BigDecimal.valueOf(valoresParcelas.size()), RoundingMode.HALF_UP);

                            BigDecimal somaPrice = simulacoes.stream()
                                    .flatMap(s -> s.getParcelas().stream().filter(p -> "PRICE".equals(p.getTipo())).map(Parcela::getVrPrestacao))
                                    .reduce(BigDecimal.ZERO, BigDecimal::add);

                            BigDecimal somaSAC = simulacoes.stream()
                                   .flatMap(s -> s.getParcelas().stream().filter(p -> "SAC".equals(p.getTipo())).map(Parcela::getVrPrestacao))
                                   .reduce(BigDecimal.ZERO, BigDecimal::add);

                           return SimulacaoMapper.toVolumeDTO(
                                   simulacoes.getFirst(),
                                   mediaPrestacoes,
                                   somaValorDesejado,
                                   somaPrice,
                                   somaSAC
                           );
                       }
                )));


        return VolumeSimuladoResponseDTO.builder()
                .dataReferencia(data)
                .simulacoes(new ArrayList<>(volumePorProduto.values()))
                .build();
    }

}
