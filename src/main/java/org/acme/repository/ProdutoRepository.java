package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.entity.Produto;
import org.acme.entity.Simulacao;

@ApplicationScoped
public class ProdutoRepository implements PanacheRepository<Produto> {
    public Produto buscaPorId(Long idProduto){
        return find("id", idProduto).firstResult();
    }

    public Produto buscaProdCorrespondente(Simulacao simulacao) {
        return find("nuMinimoMeses <= ?1 and vrMinimo <= ?2", simulacao.getPrazo(), simulacao.getValorDesejado()).firstResult();
    }
}
