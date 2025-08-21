package org.acme.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "PRODUTO", schema = "dbo")
public class Produto{
    @Id
    @Column(name = "CO_PRODUTO", nullable = false)
    private Long coProduto;

    @Column(name = "NO_PRODUTO", nullable = false)
    private String noProduto;

    @Column(name = "PC_TAXA_JUROS", nullable = false, precision = 10, scale = 9)
    private BigDecimal pcTaxaJuros;

    @Column(name = "NU_MINIMO_MESES", nullable = false)
    private Integer nuMinimoMeses;

    @Column(name = "NU_MAXIMO_MESES")
    private Integer nuMaximoMeses;

    @Column(name = "VR_MINIMO", nullable = false, precision = 18, scale = 2)
    private BigDecimal vrMinimo;

    @Column(name = "VR_MAXIMO", precision = 18, scale = 2)
    private BigDecimal vrMaximo;

    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Simulacao> simulacoes;
}
