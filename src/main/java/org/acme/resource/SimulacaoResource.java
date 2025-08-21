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

@Path("/simulacao")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SimulacaoResource {
    @Inject
    CriaSimulacaoService criaSimulacaoService;

    @POST
    @Transactional
    public Response criaSimulacao(SimulacaoRequestDTO simulacaoRequestDTO){
        SimulacaoResponseDTO simulacaoResponseDTO = criaSimulacaoService.criaSimulacao(simulacaoRequestDTO);
        return Response.status(Response.Status.OK).entity(simulacaoResponseDTO).build();
    }
}
