package com.lookiero.quehayparacomer.domain.model.ingredient;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.validation.Validation;
import javax.validation.Validator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class IngredientNutricionalValuesTest {

  private static final Double VALID_DOUBLE = 1231.123;
  private static final Double INVALID_DOUBLE =null;

  private static Validator validator;



  @BeforeAll
  static void setup() {
    final var factory = Validation.buildDefaultValidatorFactory();
    validator = factory.getValidator();
  }

  @Test
  void should_reference_is_created_correctly() {
    //given
    final var subject = new IngredientNuticialValues(VALID_DOUBLE,VALID_DOUBLE,VALID_DOUBLE);

    //when
    final var violations = validator.validate(subject);

    //then
    assertThat(violations).isEmpty();
  }

  @Test
  void should_locationId_fails_to_create_with_null() {
    assertThatThrownBy( () -> new IngredientNuticialValues(INVALID_DOUBLE,INVALID_DOUBLE,INVALID_DOUBLE)).hasNoCause();

  }
  @Test
  void should_locationId_fails_to_create_with_first_null() {
    assertThatThrownBy( () -> new IngredientNuticialValues(INVALID_DOUBLE,VALID_DOUBLE,VALID_DOUBLE)).hasNoCause();

  }
  @Test
  void should_locationId_fails_to_create_with_second_null() {
    assertThatThrownBy( () -> new IngredientNuticialValues(VALID_DOUBLE,INVALID_DOUBLE,VALID_DOUBLE)).hasNoCause();


  }  @Test
  void should_locationId_fails_to_create_with_Third_null() {

    assertThatThrownBy( () -> new IngredientNuticialValues(VALID_DOUBLE,VALID_DOUBLE,INVALID_DOUBLE)).hasNoCause();
  }
}
