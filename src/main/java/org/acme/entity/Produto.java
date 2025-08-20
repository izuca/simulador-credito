package org.acme.entity;

import io.smallrye.common.constraint.NotNull;
import io.smallrye.common.constraint.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


/**
 * Example JPA entity defined as a Panache Entity.
 * An ID field of Long type is provided, if you want to define your own ID field extends <code>PanacheEntityBase</code> instead.
 *
 * This uses the active record pattern, you can also use the repository pattern instead:
 * .
 *
 * Usage (more example on the documentation)
 *
 * {@code
 *     public void doSomething() {
 *         MyEntity entity1 = new MyEntity();
 *         entity1.field = "field-1";
 *         entity1.persist();
 *
 *         List<MyEntity> entities = MyEntity.listAll();
 *     }
 * }
 */
@Getter
@Setter
@Entity
@Table(name = "PRODUTO")
public class Produto{
    @Id
    @NotNull
    @Column(name = "CO_PRODUTO")
    private int coProduto;

    @NotNull
    @Column(name = "NO_PRODUTO")
    private String noProduto;

    @NotNull
    @Column(name = "PC_TAXA_JUROS")
    private double pcTaxaJuros;

    @NotNull
    @Column(name = "NU_MINIMO_MESES")
    private int nuMinimoMeses;

    @Nullable
    @Column(name = "NU_MAXIMO_MESES")
    private Integer nuMaximoMeses;

    @NotNull
    @Column(name = "VR_MINIMO")
    private double vrMinimo;

    @Nullable
    @Column(name = "VR_MAXIMO")
    private Double vrMaximo;

}
