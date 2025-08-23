package org.acme.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "PARCELA", schema = "dbo")
public class Parcela {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PARCELA")
    private Long idParcela;

    @Column(name="TIPO", nullable = false)
    private String tipo;

    @Column(name="NUMERO", nullable = false)
    private Integer numero;


    @Column(name = "VR_AMORTIZACAO", nullable = false, precision = 18,scale = 2)
    private BigDecimal vrAmortizacao;

    @Column(name = "VR_JUROS", nullable = false, precision = 10, scale = 9)
    private BigDecimal vrJuros;

    @Column(name = "VR_PRESTACAO", nullable = false, precision = 18,scale = 2)
    private BigDecimal vrPrestacao;

    @ManyToOne
    @JoinColumn(name = "ID_SIMULACAO", nullable = false)
    private Simulacao simulacao;
}
