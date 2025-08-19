package org.acme.entity;

import io.smallrye.common.constraint.NotNull;
import io.smallrye.common.constraint.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
public class Produto{
    @Id @NotNull
    private int coProduto;

    @NotNull
    private String noProduto;

    @NotNull
    private double pcTaxaJuros;

    @NotNull
    public int nuMinimoMeses;

    @Nullable
    public int nuMaximoMeses;

    @NotNull
    public double vrMinimo;

    @Nullable
    public double vrMaximo;
}
