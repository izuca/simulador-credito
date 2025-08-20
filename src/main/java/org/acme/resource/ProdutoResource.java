package org.acme.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.entity.Produto;
import org.acme.repository.ProdutoRepository;

import java.util.List;

@Path("/produto")
@Produces(MediaType.APPLICATION_JSON)
public class ProdutoResource {
    @Inject
    ProdutoRepository produtoRepository;

    @GET
    public Response listaProdutos(){
       List<Produto> produtos = produtoRepository.listAll();
       return Response.status(Response.Status.OK).entity(produtos).build();
    }

    @GET
    @Path("/{id}")
    public Response buscaProduto(@PathParam("id") Long coProduto){
        Produto produto = produtoRepository.findById(coProduto);
        return Response.status(Response.Status.OK).entity(produto).build();
    }


}
