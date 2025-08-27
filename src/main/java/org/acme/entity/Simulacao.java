package org.acme.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "simulacao")
public class Simulacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_simulacao")
    private Long idSimulacao;

    @Column(name = "vr_desejado", nullable = false, precision = 18, scale = 2)
    private BigDecimal valorDesejado;

    @Column(name = "prazo", nullable = false)
    private Integer prazo;

    @Column(name = "data_hora")
    private LocalDateTime dataHora;

    @ManyToOne
    @JoinColumn(name = "co_produto", nullable = false)
    private Produto produto;

    @OneToMany(mappedBy = "simulacao",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Parcela> parcelas = new ArrayList<>();

    @PrePersist
    public void prePersist() {
        if (dataHora == null) {
            dataHora = LocalDateTime.now();
        }
    }

}
