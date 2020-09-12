package com.lookiero.quehayparacomer.infrastructure.delivery.persistence.jpa.ingredient;


import com.lookiero.quehayparacomer.domain.model.ingredient.Ingredient;
import com.lookiero.quehayparacomer.domain.model.ingredient.IngredientId;
import com.lookiero.quehayparacomer.domain.model.ingredient.IngredientName;
import com.lookiero.quehayparacomer.domain.model.ingredient.IngredientNuticialValues;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@NoArgsConstructor
@Data
@Entity(name = "ingredient")
public class JpaIngredient {
    @Column(name = "ingredient_name", nullable = false)
    public String name;
    @Column(name = "ingredient_kcal", nullable = false)
    public double kcal;
    @Column(name = "ingredient_grasas", nullable = false)
    public double grasas;
    @Column(name = "ingredient_azucar", nullable = false)
    public double azucar;
    @Id
    public UUID id;


    private JpaIngredient(final Ingredient ingredient) {
        this.id = ingredient.getIngredientid().getId();
        this.name = ingredient.getIngredientName().name;
        this.kcal = ingredient.getIngredientNuticialValues().kcal;
        this.grasas = ingredient.getIngredientNuticialValues().grasas;
        this.azucar = ingredient.getIngredientNuticialValues().azucar;

    }

    public static JpaIngredient fromDomain(final Ingredient ingredient) {
        return new JpaIngredient(ingredient);
    }

    public Ingredient toDomain() {
        return Ingredient
                .builder()
                .ingredientNuticialValues(new IngredientNuticialValues(this.kcal, this.grasas, this.azucar))
                .ingredientid(new IngredientId(this.id))
                .ingredientName(new IngredientName((this.name)))
                .build();
    }

}
