package org.acme.exception.mapper;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.acme.dto.ErrorResponseDTO;
import org.acme.exception.ProdutoNaoEncontradoException;

@Provider
public class ProdutoNaoEncontradoHandler implements ExceptionMapper<ProdutoNaoEncontradoException> {
    @Override
    public Response toResponse(ProdutoNaoEncontradoException e) {
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(404, e.getMessage());
        return Response.status(Response.Status.NOT_FOUND).entity(errorResponseDTO).build();
    }
}
