package com.lookiero.quehayparacomer.domain.model.ingredient;

import com.lookiero.quehayparacomer.domain.model.DomainId;

import javax.validation.constraints.NotNull;
import java.util.UUID;

public class IngredientId extends DomainId {

    public IngredientId(@NotNull UUID id) {
        super(id);
    }
}
