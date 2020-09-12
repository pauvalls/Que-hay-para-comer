package com.lookiero.quehayparacomer;

import com.lookiero.quehayparacomer.application.CreateANewIngredient.CreateIngredient;
import com.lookiero.quehayparacomer.application.CreateANewIngredient.CreateIngredientCommand;

import java.util.UUID;

public class IngredientStubs {
    public static CreateIngredientCommand getCreateIngredientcommand(){
        return
                CreateIngredientCommand
                        .builder()
                        .uuid(UUID.randomUUID().toString())
                        .name("patata")
                        .azucar(123.123)
                        .grasas(123.123)
                        .kcal(123.123)
                        .build();
    }
}
