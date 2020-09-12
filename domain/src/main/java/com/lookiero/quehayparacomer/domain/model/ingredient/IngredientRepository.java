package com.lookiero.quehayparacomer.domain.model.ingredient;

import java.util.Optional;

public interface IngredientRepository {

    Optional<Ingredient> findByName(final IngredientName ingredientName);
    void save(final Ingredient ingredient);
}
