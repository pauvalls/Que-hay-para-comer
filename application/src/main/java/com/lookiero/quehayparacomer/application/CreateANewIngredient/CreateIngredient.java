package com.lookiero.quehayparacomer.application.CreateANewIngredient;

import com.lookiero.quehayparacomer.domain.model.ingredient.*;

import java.util.UUID;

public class CreateIngredient {
    private final IngredientRepository ingredientRepository;

    public CreateIngredient(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public Ingredient execute(CreateIngredientCommand createIngredientCommand) {
        final var ingredient = Ingredient
                .builder()
                .ingredientid(new IngredientId(UUID.fromString(createIngredientCommand.uuid)))
                .ingredientName(new IngredientName(createIngredientCommand.name))
                .ingredientNuticialValues(new IngredientNuticialValues(
                        createIngredientCommand.kcal,
                        createIngredientCommand.grasas,
                        createIngredientCommand.azucar)
                )
                .build();

        ingredientRepository.save(ingredient);
        return ingredient;
    }
}
