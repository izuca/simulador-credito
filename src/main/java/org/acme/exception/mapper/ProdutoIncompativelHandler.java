package org.acme.exception.mapper;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.acme.dto.ErrorResponseDTO;
import org.acme.exception.ProdutoIncompativelException;

@Provider
public class ProdutoIncompativelHandler implements ExceptionMapper<ProdutoIncompativelException> {
    @Override
    public Response toResponse(ProdutoIncompativelException e) {
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(ErrorResponseDTO.builder()
                        .codigoHttp(400)
                        .mensagem(e.getMessage())
                        .build())
                .build();
    }
}
