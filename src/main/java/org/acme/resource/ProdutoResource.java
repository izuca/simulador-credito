package org.acme.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.dto.ProdutoDTO;
import org.acme.dto.mapper.ProdutoMapper;
import org.acme.entity.Produto;
import org.acme.repository.ProdutoRepository;
import org.acme.services.ProdutoService;

import java.util.ArrayList;
import java.util.List;

@Path("/produto")
@Produces(MediaType.APPLICATION_JSON)
public class ProdutoResource {
    @Inject
    ProdutoRepository produtoRepository;

    @Inject
    ProdutoService produtoService;

    @Inject
    ProdutoMapper produtoMapper;

    @GET
    public Response listaProdutos(){
        var listProdutoDTO = new ArrayList<ProdutoDTO>();
        for (Produto produtoEntity : produtoRepository.listAll()) {
            listProdutoDTO.add(produtoMapper.toDto(produtoEntity));
        }
       return Response.status(Response.Status.OK).entity(listProdutoDTO).build();
    }

    @GET
    @Path("/{id}")
    public Response buscaProduto(@PathParam("id") Long coProduto){
        ProdutoDTO produtoDTO = produtoService.buscarProdutoByID(coProduto);
        return Response.status(Response.Status.OK).entity(produtoDTO).build();
    }


}
