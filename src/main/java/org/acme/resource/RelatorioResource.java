package org.acme.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.services.VolumeSimuladoService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

@Path("/relatorios")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RelatorioResource {
    @Inject
    VolumeSimuladoService volumeSimuladoService;

    @GET
    @Operation(summary = "Listar Volumetria por Produto", description = "Lista dados estatísticos por produto")
    @APIResponse(responseCode = "200", content = @Content(mediaType = "application/json"))
    public Response listarVolume(@QueryParam("dataReferencia") String dataReferencia) {
        return Response.status(Response.Status.OK)
                .entity(volumeSimuladoService.listarVolumeProduto(dataReferencia))
                .build();
    }
}
