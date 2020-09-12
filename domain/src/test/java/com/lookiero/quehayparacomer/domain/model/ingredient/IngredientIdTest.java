package com.lookiero.quehayparacomer.domain.model.ingredient;

import com.lookiero.quehayparacomer.domain.model.DomainId;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.validation.Validation;
import javax.validation.Validator;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class IngredientIdTest {

  private static final UUID VALID_UUID = UUID.randomUUID();

  private static Validator validator;



  @BeforeAll
  static void setup() {
    final var factory = Validation.buildDefaultValidatorFactory();
    validator = factory.getValidator();
  }

  @Test
  void should_reference_is_created_correctly() {
    //given
    final var subject = new IngredientId(VALID_UUID);

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
