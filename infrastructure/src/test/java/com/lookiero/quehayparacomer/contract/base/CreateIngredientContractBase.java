package com.lookiero.quehayparacomer.contract.base;

import com.lookiero.quehayparacomer.application.CreateANewIngredient.CreateIngredient;
import com.lookiero.quehayparacomer.domain.model.ingredient.Ingredient;
import com.lookiero.quehayparacomer.domain.model.ingredient.IngredientId;
import com.lookiero.quehayparacomer.domain.model.ingredient.IngredientName;
import com.lookiero.quehayparacomer.domain.model.ingredient.IngredientNuticialValues;
import com.lookiero.quehayparacomer.infrastructure.delivery.springboot.controller.createingredient.CreateIngredientController;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.standaloneSetup;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CreateIngredientContractBase {
    @Mock
    CreateIngredient createIngredient;
    @InjectMocks
    CreateIngredientController subject;

    void setUp() {
        when(createIngredient.execute(any())).thenReturn(
                Ingredient
                        .builder()
                        .ingredientName(new IngredientName("patata"))
                        .ingredientid(new IngredientId(UUID.randomUUID()))
                        .ingredientNuticialValues(new IngredientNuticialValues(1.1, 2.2, 123.2))
                        .build()
        );
        standaloneSetup(subject);
        
    }


}
