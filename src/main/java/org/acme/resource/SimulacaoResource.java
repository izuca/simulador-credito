package org.acme.resource;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.dto.SimulacaoRequestDTO;
import org.acme.dto.SimulacaoResponseDTO;
import org.acme.services.CriaSimulacaoService;
import org.eclipse.microprofile.openapi.annotations.*;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;


@Path("/simulacoes")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SimulacaoResource {
    @Inject
    CriaSimulacaoService criaSimulacaoService;

    @POST
    @Operation(summary = "Cria uma nova simulação", description = "Cria uma nova simulação com base nos dados fornecidos.")
    @APIResponse(responseCode = "201", description = "Simulação criada com sucesso",
                 content = @Content(mediaType = "application/json")
    @Transactional
    public Response criaSimulacao(SimulacaoRequestDTO simulacaoRequestDTO){
        SimulacaoResponseDTO simulacaoResponseDTO = criaSimulacaoService.criaSimulacao(simulacaoRequestDTO);
        return Response.status(Response.Status.CREATED).entity(simulacaoResponseDTO).build();
    }
}
