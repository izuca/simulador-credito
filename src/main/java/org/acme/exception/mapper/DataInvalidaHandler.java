package org.acme.exception.mapper;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.acme.dto.ErrorResponseDTO;
import org.acme.exception.DataInvalidaException;

@Provider
public class DataInvalidaHandler implements ExceptionMapper<DataInvalidaException>{
    @Override
    public Response toResponse(DataInvalidaException e) {
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(ErrorResponseDTO.builder()
                        .codigoHttp(400)
                        .mensagem(e.getMessage())
                        .build()
                )
                .build();
    }
}

