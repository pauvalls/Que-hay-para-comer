package com.lookiero.quehayparacomer.infrastructure.delivery.springboot.config;

import com.lookiero.quehayparacomer.application.CreateANewIngredient.CreateIngredient;
import com.lookiero.quehayparacomer.domain.model.ingredient.IngredientRepository;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCasesConfig {
    @Bean
    CreateIngredient createIngredient(final IngredientRepository ingredientRepository){
        return new CreateIngredient(ingredientRepository);
    }
}
