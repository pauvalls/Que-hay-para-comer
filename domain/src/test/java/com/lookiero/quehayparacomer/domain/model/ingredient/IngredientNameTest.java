package com.lookiero.quehayparacomer.domain.model.ingredient;

import groovy.util.StringTestUtil;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

import javax.validation.Validation;
import javax.validation.Validator;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class IngredientNameTest {

  private static final String VALID_STRING = "patata";

  private static Validator validator;



  @BeforeAll
  static void setup() {
    final var factory = Validation.buildDefaultValidatorFactory();
    validator = factory.getValidator();
  }

  @Test
  void should_reference_is_created_correctly() {
    //given
    final var subject = new IngredientName(VALID_STRING);

    //when
    final var violations = validator.validate(subject);

    //then
    assertThat(violations).isEmpty();
  }

  @Test
  void should_locationId_fails_to_create_with_null() {
    //given
    final var subject = new IngredientId(null);

    //when
    final var violations = validator.validate(subject);

    //then
    assertThat(violations).hasSize(1);
  }
}
