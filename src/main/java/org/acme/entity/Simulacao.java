package org.acme.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "SIMULACAO" , schema = "dbo")
public class Simulacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_SIMULACAO")
    private Long idSimulacao;

    @Column(name = "VALOR_DESEJADO", nullable = false, precision = 18, scale = 2)
    private BigDecimal valorDesejado;

    @Column(name = "PRAZO", nullable = false)
    private Integer prazo;

    @Column(name = "DATA_HORA")
    private LocalDateTime dataHora = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "CO_PRODUTO", nullable = false)
    private Produto produto;

    @OneToMany(mappedBy = "simulacao", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Parcela> parcelas;


}
