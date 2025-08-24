package org.acme.services;

import jakarta.enterprise.context.ApplicationScoped;
import org.acme.entity.Parcela;
import org.acme.entity.Simulacao;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ParcelaService {

    public List<Parcela> calculaSAC(Simulacao simulacao) {
        BigDecimal vrAmortizacaoTotal = simulacao.getValorDesejado();
        BigDecimal saldoDevedor = vrAmortizacaoTotal;
        BigDecimal taxaJuros = simulacao.getProduto().getPcTaxaJuros();
        Integer qtdParcelas = simulacao.getPrazo();
        List<Parcela> parcelaList = new ArrayList<>();

        BigDecimal amortizacaoFixa = vrAmortizacaoTotal.divide(BigDecimal.valueOf(qtdParcelas), 2, RoundingMode.HALF_UP);

        for (int i = 1; i <= qtdParcelas; i++) {

            BigDecimal juros = taxaJuros.multiply(saldoDevedor).setScale(2, RoundingMode.HALF_UP);
            BigDecimal prestacao = amortizacaoFixa.add(juros);

            Parcela parcela = Parcela.builder()
                    .tipo("SAC")
                    .numero(i)
                    .vrAmortizacao(amortizacaoFixa)
                    .vrJuros(juros)
                    .vrPrestacao(prestacao)
                    .simulacao(simulacao)
                    .build();
            saldoDevedor = saldoDevedor.subtract(parcela.getVrAmortizacao());

            simulacao.getParcelas().add(parcela);
            parcelaList.add(parcela);
        }
        return parcelaList;
    }

    public List<Parcela> calculaPrice(Simulacao simulacao) {
        BigDecimal vrAmortizacaoTotal = simulacao.getValorDesejado();
        BigDecimal saldoDevedor = vrAmortizacaoTotal;
        BigDecimal taxaJuros = simulacao.getProduto().getPcTaxaJuros();
        Integer qtdParcelas = simulacao.getPrazo();
        List<Parcela> parcelaList = new ArrayList<>();

        BigDecimal coeficiente = taxaJuros
                .multiply(
                        BigDecimal.ONE.add(taxaJuros)
                                .pow(qtdParcelas))
                .divide(
                        BigDecimal.ONE.add(taxaJuros)
                                .pow(qtdParcelas)
                                .subtract(BigDecimal.ONE)
                        ,6
                        ,RoundingMode.HALF_UP
                );
        BigDecimal prestacao = vrAmortizacaoTotal.multiply(coeficiente).setScale(2, RoundingMode.DOWN);

        for (int i = 1; i <= qtdParcelas; i++) {
            BigDecimal juros = taxaJuros.multiply(saldoDevedor).setScale(2, RoundingMode.HALF_UP);
            BigDecimal amortizacaoAtual = prestacao.subtract(juros);

            Parcela parcela = Parcela.builder()
                    .tipo("PRICE")
                    .numero(i)
                    .vrAmortizacao(amortizacaoAtual)
                    .vrJuros(juros)
                    .vrPrestacao(prestacao)
                    .simulacao(simulacao)
                    .build();
            saldoDevedor = saldoDevedor.subtract(parcela.getVrAmortizacao());

            simulacao.getParcelas().add(parcela);
            parcelaList.add(parcela);
        }
        return parcelaList;
    }


}
