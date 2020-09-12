package com.lookiero.quehayparacomer.domain.model;

import java.util.UUID;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
public class DomainId {

  @NotNull
  private final UUID id;

  @Override
  public String toString() {
    return id.toString();
  }
}
