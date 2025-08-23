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
            Parcela parcela = new Parcela();

            BigDecimal juros = taxaJuros.multiply(saldoDevedor).setScale(2, RoundingMode.HALF_UP);
            BigDecimal prestacao = amortizacaoFixa.add(juros);

            parcela.setTipo("SAC");
            parcela.setNumero(i);
            parcela.setVrAmortizacao(amortizacaoFixa);
            parcela.setVrJuros(juros);
            parcela.setVrPrestacao(prestacao);
            parcela.setSimulacao(simulacao);
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
            Parcela parcela = new Parcela();

            BigDecimal juros = taxaJuros.multiply(saldoDevedor).setScale(2, RoundingMode.HALF_UP);
            BigDecimal amortizacaoAtual = prestacao.subtract(juros);

            parcela.setTipo("PRICE");
            parcela.setNumero(i);
            parcela.setVrAmortizacao(amortizacaoAtual);
            parcela.setVrJuros(juros);
            parcela.setVrPrestacao(prestacao);
            parcela.setSimulacao(simulacao);
            saldoDevedor = saldoDevedor.subtract(parcela.getVrAmortizacao());

            simulacao.getParcelas().add(parcela);
            parcelaList.add(parcela);
        }
        return parcelaList;
    }


}
