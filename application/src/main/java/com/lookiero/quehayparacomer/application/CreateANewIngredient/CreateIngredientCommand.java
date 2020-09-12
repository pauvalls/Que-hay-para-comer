package com.lookiero.quehayparacomer.application.CreateANewIngredient;

import lombok.Builder;
import lombok.Data;

@Builder
public class CreateIngredientCommand {
    public final String name;
    public final String uuid;
    public final Double kcal;
    public final Double grasas;
    public final Double azucar;
}
