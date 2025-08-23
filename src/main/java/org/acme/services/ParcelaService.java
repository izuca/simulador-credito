package org.acme.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.dto.ParcelaDTO;
import org.acme.dto.mapper.ParcelaMapper;
import org.acme.entity.Parcela;
import org.acme.entity.Simulacao;
import org.acme.repository.ParcelaRepository;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ParcelaService {
    @Inject
    ParcelaRepository parcelaRepository;

    public List<ParcelaDTO> calculaSAC(Simulacao simulacao) {
        BigDecimal vrAmortizacaoTotal = simulacao.getValorDesejado();
        BigDecimal saldoDevedor = vrAmortizacaoTotal;
        BigDecimal taxaJuros = simulacao.getProduto().getPcTaxaJuros();
        Integer qtdParcelas = simulacao.getPrazo();
        List<ParcelaDTO> parcelaDTOList = new ArrayList<>();

        BigDecimal amortizacaoFixa = vrAmortizacaoTotal.divide(BigDecimal.valueOf(qtdParcelas), 2, RoundingMode.HALF_UP);

        for (int i = 1; i <= qtdParcelas; i++) {
            Parcela parcela = new Parcela();

            BigDecimal juros = taxaJuros.multiply(saldoDevedor).setScale(2, RoundingMode.HALF_UP);
            BigDecimal prestacao = amortizacaoFixa.add(juros);

            parcela.setTipo("SAC");
            parcela.setNumero(i);
            parcela.setVrAmortizacao(amortizacaoFixa);
            parcela.setVrJuros(juros);
            parcela.setVrPrestacao(prestacao);
            parcela.setSimulacao(simulacao);
            saldoDevedor = saldoDevedor.subtract(parcela.getVrPrestacao());

            ParcelaDTO parcelaDTO = ParcelaMapper.toDto(parcela);
            parcelaDTOList.add(parcelaDTO);
//            parcelaRepository.persist(parcela); nao ta persistindo o BD
        }
        return parcelaDTOList;
    }
}
