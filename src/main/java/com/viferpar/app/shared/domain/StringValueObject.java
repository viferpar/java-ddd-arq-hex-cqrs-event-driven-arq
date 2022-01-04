package com.viferpar.app.shared.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
public abstract class StringValueObject {

  private String value;

  @Override
  public String toString() {
    return this.value;
  }

}
