package com.lookiero.quehayparacomer.infrastructure.delivery.persistence.jpa.ingredient;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaIngredientRepository extends JpaRepository<JpaIngredient, UUID> {

}
