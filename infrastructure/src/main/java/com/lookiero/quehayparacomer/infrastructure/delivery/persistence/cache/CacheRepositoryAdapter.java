package com.lookiero.quehayparacomer.infrastructure.delivery.persistence.cache;

import com.lookiero.quehayparacomer.domain.model.ingredient.Ingredient;
import com.lookiero.quehayparacomer.domain.model.ingredient.IngredientName;
import com.lookiero.quehayparacomer.domain.model.ingredient.IngredientRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CacheRepositoryAdapter implements IngredientRepository {
    public static List<Ingredient> cache = new ArrayList<>();

    @Override
    public Optional<Ingredient> findByName(IngredientName ingredientName) {
        var result = cache.stream()
                .filter(ingredient -> ingredient.getIngredientName().name.contains(ingredientName.name))
                .findFirst()
                .get();
        return Optional.of(result);
    }

    @Override
    public void save(Ingredient ingredient) {
        cache.add(ingredient);
    }
}
