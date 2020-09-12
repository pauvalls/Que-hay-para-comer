package com.lookiero.quehayparacomer.domain.model.ingredient;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.validation.Validation;
import javax.validation.Validator;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class IngredientTest {

  private static final UUID VALID_UUID = UUID.randomUUID();
  private static final String VALID_STRING = "patata";
  private static final Double VALID_DOUBLE = 123.123;

  private static Validator validator;



  @BeforeAll
  static void setup() {
    final var factory = Validation.buildDefaultValidatorFactory();
    validator = factory.getValidator();
  }

  @Test
  void should_reference_is_created_correctly() {
    //given
    final var subject =
            Ingredient
                    .builder()
            .ingredientid(new IngredientId(VALID_UUID))
            .ingredientName(new IngredientName((VALID_STRING)))
            .ingredientNuticialValues(new IngredientNuticialValues(VALID_DOUBLE,VALID_DOUBLE,VALID_DOUBLE))
            .build();

    //when
    final var violations = validator.validate(subject);

    //then
    assertThat(violations).isEmpty();
  }

  @Test
  void should_locationId_fails_to_create_with_Id_null() {
    //given
    final var subject = Ingredient
            .builder()
            .ingredientid(null)
            .ingredientName(new IngredientName((VALID_STRING)))
            .ingredientNuticialValues(new IngredientNuticialValues(VALID_DOUBLE,VALID_DOUBLE,VALID_DOUBLE))
            .build();;

    //when
    final var violations = validator.validate(subject);

    //then
    assertThat(violations).hasSize(1);
  }
  @Test
  void should_locationId_fails_to_create_with_name_null() {
    //given
    final var subject = Ingredient
            .builder()
            .ingredientid(new IngredientId(VALID_UUID))
            .ingredientName(null)
            .ingredientNuticialValues(new IngredientNuticialValues(VALID_DOUBLE,VALID_DOUBLE,VALID_DOUBLE))
            .build();;

    //when
    final var violations = validator.validate(subject);

    //then
    assertThat(violations).hasSize(1);
  }  @Test
  void should_locationId_fails_to_create_with_nutricionalValues_null() {
    //given
    final var subject = Ingredient
            .builder()
            .ingredientid(new IngredientId(VALID_UUID))
            .ingredientName(new IngredientName((VALID_STRING)))
            .ingredientNuticialValues(null)
            .build();;

    //when
    final var violations = validator.validate(subject);

    //then
    assertThat(violations).hasSize(1);
  }
}
