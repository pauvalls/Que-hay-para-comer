package com.lookiero.quehayparacomer.domain.model.ingredient;

import com.lookiero.quehayparacomer.domain.model.DomainId;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Builder
public class Ingredient {
    @NotNull
    private IngredientId ingredientid;
    @NotNull
    private IngredientName ingredientName;
    @NotNull
    private IngredientNuticialValues ingredientNuticialValues;
}
