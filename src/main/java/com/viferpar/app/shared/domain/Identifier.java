package com.viferpar.app.shared.domain;

import java.util.UUID;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode
@Getter
@Setter
public abstract class Identifier {

  private final String value;

  protected Identifier(String value) {
    ensureValidUuid(value);
    this.value = value;
  }

  private void ensureValidUuid(String value) throws IllegalArgumentException {
    UUID.fromString(value);
  }

  @Override
  public String toString(){
    return this.value;
  }

}
