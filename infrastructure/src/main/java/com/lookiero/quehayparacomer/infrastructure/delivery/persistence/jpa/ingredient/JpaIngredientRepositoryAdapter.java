package com.lookiero.quehayparacomer.infrastructure.delivery.persistence.jpa.ingredient;

import com.lookiero.quehayparacomer.domain.model.ingredient.Ingredient;
import com.lookiero.quehayparacomer.domain.model.ingredient.IngredientName;
import com.lookiero.quehayparacomer.domain.model.ingredient.IngredientRepository;
import lombok.extern.log4j.Log4j2;

import java.util.Optional;
@Log4j2
public class JpaIngredientRepositoryAdapter implements IngredientRepository {
    private JpaIngredientRepository repository;

    public JpaIngredientRepositoryAdapter(JpaIngredientRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Ingredient> findByName(IngredientName ingredientName) {
        return Optional.empty();
    }

    @Override
    public void save(Ingredient ingredient) {
        System.out.println( "he entrado aquiii ");
        log.debug("pruebalogs debug");
        repository.save(JpaIngredient.fromDomain(ingredient));
    }
}
