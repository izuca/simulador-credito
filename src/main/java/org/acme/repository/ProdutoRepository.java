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
        return find("?1 between vrMinimo and coalesce(vrMaximo,?1) and ?2 between nuMinimoMeses and coalesce(nuMaximoMeses, ?2)"
                ,simulacao.getValorDesejado()
                ,simulacao.getPrazo()
        ).firstResult();
    }
}