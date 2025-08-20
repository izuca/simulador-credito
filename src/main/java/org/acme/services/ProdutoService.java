package org.acme.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.dto.ProdutoDTO;
import org.acme.dto.mapper.ProdutoMapper;
import org.acme.entity.Produto;
import org.acme.repository.ProdutoRepository;

@ApplicationScoped
public class ProdutoService {
    @Inject
    ProdutoRepository produtoRepository;

    @Inject
    ProdutoMapper produtoMapper;

    public ProdutoDTO buscarProdutoByID(Long id) {
        Produto produto = produtoRepository.buscaPorId(id);
        return produtoMapper.toDto(produto);
    }

}
