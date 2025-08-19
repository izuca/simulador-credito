package org.acme.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.acme.repository.ProdutoRepository;

@Path("/teste")
public class TesteResource {
    @Inject
    ProdutoRepository produtoRepository;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String teste(){
        return produtoRepository.teste();
    }
/*
* No meu leigo entender Entity(Representação da Tabela no Banco de Dados) -> Repository(onde está nossas regras de negócio) -> Resource(onde fica os Endpoints)
* */
}
