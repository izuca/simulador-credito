package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.entity.Simulacao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@ApplicationScoped
public class SimulacaoRepository implements PanacheRepository<Simulacao> {
    public List<Simulacao> buscarPorData(LocalDate dataReferencia) {
        LocalDateTime dtInicio = dataReferencia.atStartOfDay();
        LocalDateTime dtFim = dataReferencia.atTime(23, 59, 59);

        return list("dataHora between ?1 and ?2", dtInicio, dtFim);
    }
}
