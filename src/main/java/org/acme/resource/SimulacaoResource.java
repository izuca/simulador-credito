package org.acme.resource;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.dto.CriaSimulacaoRequestDTO;
import org.acme.services.CriaSimulacaoService;
import org.acme.services.ListaSimulacaoService;
import org.eclipse.microprofile.openapi.annotations.*;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.media.Content;

@Path("/simulacoes")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SimulacaoResource {
    @Inject
    CriaSimulacaoService criaSimulacaoService;

    @Inject
    ListaSimulacaoService listaSimulacaoService;

    @GET
    @Operation(summary = "Listar simulações", description = "Lista simulações com paginação e quantidade de registros por página")
    @APIResponse(responseCode = "200", content = @Content(mediaType = "application/json"))
    public Response listarSimulacoes(@QueryParam("pagina") @DefaultValue("1") @Min(1) int pagina,
                                     @QueryParam("qtdRegistrosPagina") @DefaultValue("50") int qtdRegistrosPagina) {

        return Response.status(Response.Status.OK)
                .entity(listaSimulacaoService.listarSimulacoes(pagina,qtdRegistrosPagina))
                .build();
    }

    @POST
    @Operation(summary = "Criar simulação", description = "Cria uma nova simulação com base nos dados fornecidos.")
    @APIResponse(responseCode = "201", description = "Simulação criada com sucesso", content = @Content(mediaType = "application/json"))
    @Transactional
    public Response criaSimulacao(@Valid CriaSimulacaoRequestDTO criaSimulacaoRequestDTO){
        return Response.status(Response.Status.CREATED)
                .entity(criaSimulacaoService.criaSimulacao(criaSimulacaoRequestDTO))
                .build();
    }
}
