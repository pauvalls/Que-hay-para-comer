package com.lookiero.quehayparacomer;

import com.lookiero.quehayparacomer.application.CreateANewIngredient.CreateIngredient;
import com.lookiero.quehayparacomer.application.CreateANewIngredient.CreateIngredientCommand;
import com.lookiero.quehayparacomer.domain.model.ingredient.Ingredient;
import com.lookiero.quehayparacomer.domain.model.ingredient.IngredientRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class CreateIngredientTest {

    @Mock
    IngredientRepository ingredientRepository;

    @InjectMocks
    CreateIngredient createIngredient;

    @Test
    void Should_save_new_ingredient_when_method_is_called() {
        //given
        doNothing().when(ingredientRepository).save(any(Ingredient.class));
        //when
        createIngredient.execute(IngredientStubs.getCreateIngredientcommand());
        //then
        verify(ingredientRepository).save(any(Ingredient.class));
    }
}
