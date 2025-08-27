package org.acme.services;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.dto.EndpointsDTO;
import org.acme.dto.TelemetriaResponseDTO;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@ApplicationScoped
public class TelemetriaService {
    @Inject
    MeterRegistry meterRegistry;

    private static final Map<String, String> URI_TO_NAME_MAP = Map.of(
            "/produtos","Produtos",
            "/simulacoes", "Simulacoes",
            "/relatorios", "Relatorios",
            "/relatorios/telemetria", "Telemetria"
    );

    public TelemetriaResponseDTO getTelemetry() {

        List<EndpointsDTO> endpointsDTOList = meterRegistry.find("http.server.requests")
                .timers()
                .stream()
                .map(timer -> {
                    String uri = timer.getId().getTag("uri");
                    if (uri == null || uri.startsWith("/q")) {
                        return null;
                    }

                    return EndpointsDTO.builder()
                            .nomeApi(uri)
                            .qtdRequisicoes(timer.count())
                            .tempoMedio((int) timer.mean(TimeUnit.MILLISECONDS))
                            .tempoMaximo((int) timer.max(TimeUnit.MILLISECONDS))
//                            .percentualSucesso( sucesso.count() / timer.count())
                            .build();

                })
                .collect(Collectors.toList());

//        meterRegistry.find("http.server.requests").timers().forEach(timer -> {
//            String uri = timer.getId().getTag("uri");
//            String method = timer.getId().getTag("method");
//            String status = timer.getId().getTag("status");
//            System.out.println(String.format("Timer encontrado - URI: %s, Method: %s, Status: %s, Count: %d",
//                    uri, method, status, timer.count()));
//        });

        return TelemetriaResponseDTO.builder()
                .dataReferencia(LocalDate.now())
                .listaEndpoints(endpointsDTOList)
                .build();
    }
}
