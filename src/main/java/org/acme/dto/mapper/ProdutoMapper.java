package org.acme.dto.mapper;

import jakarta.enterprise.context.ApplicationScoped;
import org.acme.dto.ProdutoDTO;
import org.acme.entity.Produto;

@ApplicationScoped
public class ProdutoMapper {
    public static ProdutoDTO toDto(Produto produto){
        ProdutoDTO produtoDTO = new ProdutoDTO();
        produtoDTO.setCoProduto(produto.getCoProduto());
        produtoDTO.setNoProduto(produto.getNoProduto());
        return produtoDTO;
    }
}
