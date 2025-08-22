package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.entity.Parcela;

@ApplicationScoped
public class ParcelaRepository implements PanacheRepository<Parcela> {
}
