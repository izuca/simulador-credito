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
import org.acme.repository.ProdutoRepository;
import org.acme.services.ProdutoService;
import org.eclipse.microprofile.openapi.annotations.*;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.media.Content;


import java.util.stream.Collectors;

@Path("/produtos")
@Produces(MediaType.APPLICATION_JSON)
public class ProdutoResource {
    @Inject
    ProdutoRepository produtoRepository;

    @Inject
    ProdutoService produtoService;

    @GET
    @Operation(summary = "Lista todos os produtos", description = "Lista todos os produtos cadastrados no sistema")
    @APIResponse(responseCode = "200", description = "Lista de produtos retornada com sucesso", content = @Content(mediaType = "application/json"))
    public Response listaProdutos(){
        return Response.status(Response.Status.OK)
                .entity(produtoRepository.listAll()
                    .stream()
                    .map(ProdutoMapper::toDto)
                    .collect(Collectors.toList()))
                .build();
    }

    @GET
    @Path("/{id}")
    @Operation(summary = "Busca um produto por ID", description = "Busca um produto cadastrado no sistema pelo seu ID")
    @APIResponse(responseCode = "200", description = "Produto retornado com sucesso", content = @Content(mediaType = "application/json"))
    public Response buscaProduto(@PathParam("id") Long coProduto){
        ProdutoDTO produtoDTO = produtoService.buscarProdutoByID(coProduto);
        return Response.status(Response.Status.OK)
                .entity(produtoDTO)
                .build();
    }


}
