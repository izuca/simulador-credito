package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.entity.Simulacao;

@ApplicationScoped
public class SimulacaoRepository implements PanacheRepository<Simulacao> {

}
