package org.acme.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.services.TelemetriaService;
import org.acme.services.VolumeSimuladoService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("/relatorios")
@Tag(name = "Relatórios", description = "Endpoints utilizados para a consulta de Volumetria e Telemetria")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RelatorioResource {
    @Inject
    VolumeSimuladoService volumeSimuladoService;

    @Inject
    TelemetriaService telemetriaService;

    @GET
    @Operation(summary = "Listar Volumetria por Produto", description = "Lista dados estatísticos por produto")
    @APIResponse(responseCode = "200", content = @Content(mediaType = "application/json"))
    public Response listarVolume(@QueryParam("dataReferencia") String dataReferencia) {
        return Response.status(Response.Status.OK)
                .entity(volumeSimuladoService.listarVolumeProduto(dataReferencia))
                .build();
    }

    @GET
    @Path("/telemetria")
    @Operation(summary = "Listar telemetria por Endpoint", description = "Lista dados por endpoints com base na data de referencia")
    @APIResponse(responseCode = "200", content = @Content(mediaType = "application/json"))
    public Response listarTelemetria() {

        return Response.status(Response.Status.OK)
                .entity(telemetriaService.getTelemetry())
                .build();
    }
}
