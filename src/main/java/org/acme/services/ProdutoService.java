package org.acme.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.NotFoundException;
import org.acme.dto.ProdutoDTO;
import org.acme.dto.mapper.ProdutoMapper;
import org.acme.entity.Produto;
import org.acme.exception.ProdutoNaoEncontradoException;
import org.acme.repository.ProdutoRepository;

@ApplicationScoped
public class ProdutoService {
    @Inject
    ProdutoRepository produtoRepository;

    public ProdutoDTO buscarProdutoByID(Long id) {

        Produto produto = produtoRepository.buscaPorId(id);
        if(produto == null){
            throw new ProdutoNaoEncontradoException("Produto não encontrado");
        }
        return ProdutoMapper.toDto(produto);
    }

}
