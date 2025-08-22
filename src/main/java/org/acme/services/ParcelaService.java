package org.acme.services;

import jakarta.enterprise.context.ApplicationScoped;
import org.acme.entity.Parcela;
import org.acme.entity.Simulacao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ParcelaService {
    public List<Parcela> calculaSAC(Simulacao simulacao) {
        BigDecimal vrAmortizacaoTotal = simulacao.getValorDesejado();
        BigDecimal saldoDevedor = vrAmortizacaoTotal;
        Integer qtdParcelas = simulacao.getPrazo();
        List<Parcela> parcelas = new ArrayList<>();

        saldoDevedor = vrAmortizacaoTotal;
        for (int i = 1; i < qtdParcelas; i++) {
            Parcela parcela = new Parcela();

            parcela.setTipo("SAC");
            parcela.setNumero(i);
            parcela.setVrAmortizacao(vrAmortizacaoTotal.divide(BigDecimal.valueOf(qtdParcelas.longValue())));
            parcela.setValorJuros(simulacao.getProduto().getPcTaxaJuros().multiply(saldoDevedor));
            parcela.setValorPrestacao(parcela.getValorJuros().add(parcela.getValorJuros()));

            saldoDevedor.subtract(parcela.getValorPrestacao());
            parcelas.add(parcela);
        }

        return parcelas;
    }
}
