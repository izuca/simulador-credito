package org.acme.exception.mapper;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.acme.dto.ErrorResponseDTO;
import org.acme.exception.ParametroNuloException;


@Provider
public class ParametroNuloHandler implements ExceptionMapper<ParametroNuloException>{
    @Override
    public Response toResponse(ParametroNuloException e){
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(400, e.getMessage());
        return Response.status(Response.Status.BAD_REQUEST).entity(errorResponseDTO).build();
    }
}