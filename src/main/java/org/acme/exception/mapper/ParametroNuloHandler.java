package org.acme.exception.mapper;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import tech.ada.exception.TitleAlreadyExistsException;

@Provider
public class ParametroNuloHandler implements ExceptionMapper<ParametroNuloException>{
    @Override
    public Response toResponse(ParametroNuloException e){
        return Response
                .status(Response.Status.BAD_REQUEST)
                .entity(e.getMessage())
                .build();
    }
}