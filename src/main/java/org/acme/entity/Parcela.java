package org.acme.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "parcela")
public class Parcela {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_parcela")
    private Long idParcela;

    @Column(name="tipo", nullable = false)
    private String tipo;

    @Column(name="numero", nullable = false)
    private Integer numero;


    @Column(name = "vr_amortizacao", nullable = false, precision = 18,scale = 2)
    private BigDecimal vrAmortizacao;

    @Column(name = "vr_juros", nullable = false, precision = 18, scale = 2)
    private BigDecimal vrJuros;

    @Column(name = "vr_prestacao", nullable = false, precision = 18,scale = 2)
    private BigDecimal vrPrestacao;

    @ManyToOne
    @JoinColumn(name = "id_simulacao")
    private Simulacao simulacao;
}
