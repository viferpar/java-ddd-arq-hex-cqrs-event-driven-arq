package com.viferpar.app.shared.domain;

import java.util.UUID;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
public abstract class Identifier {

  @Getter
  final protected String value;

  public Identifier(String value) {
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
