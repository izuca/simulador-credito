package org.acme.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "produto")
public class Produto{
    @Id
    @Column(name = "co_produto", nullable = false)
    private Long coProduto;

    @Column(name = "no_produto", nullable = false)
    private String noProduto;

    @Column(name = "pc_taxa_juros", nullable = false, precision = 10, scale = 9)
    private BigDecimal pcTaxaJuros;

    @Column(name = "nu_minimo_meses", nullable = false)
    private Integer nuMinimoMeses;

    @Column(name = "nu_maximo_meses")
    private Integer nuMaximoMeses;

    @Column(name = "vr_minimo", nullable = false, precision = 18, scale = 2)
    private BigDecimal vrMinimo;

    @Column(name = "vr_maximo", precision = 18, scale = 2)
    private BigDecimal vrMaximo;

    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Simulacao> simulacoes;
}
