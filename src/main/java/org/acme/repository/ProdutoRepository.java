package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.entity.Produto;

@ApplicationScoped
public class ProdutoRepository implements PanacheRepository<Produto> {
    public Produto buscaPorId(int idProduto){
        return find("id", idProduto).firstResult();
    }

    public String teste(){
        return "O teste funcionou";
    }
}
