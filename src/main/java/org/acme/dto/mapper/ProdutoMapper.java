package org.acme.dto.mapper;

import org.acme.dto.ProdutoDTO;
import org.acme.entity.Produto;

public class ProdutoMapper {
    public static ProdutoDTO toDto(Produto produto){
        return ProdutoDTO.builder()
                .coProduto(produto.getCoProduto())
                .noProduto(produto.getNoProduto())
                .build();

    }
}
