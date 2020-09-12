package com.lookiero.quehayparacomer.domain.model.ingredient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
public class IngredientNuticialValues {
    public double kcal;
    public double grasas;
    public double azucar;

}
