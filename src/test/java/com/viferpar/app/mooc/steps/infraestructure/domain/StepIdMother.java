package com.viferpar.app.mooc.steps.infraestructure.domain;

import com.viferpar.app.mooc.steps.domain.StepId;
import com.viferpar.app.shared.domain.UuidMother;

public final class StepIdMother {

  public static StepId create(String value) {
    return new StepId(value);
  }

  public static StepId random() {
    return create(UuidMother.random());
  }

}
