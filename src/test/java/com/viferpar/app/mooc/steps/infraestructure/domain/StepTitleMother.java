package com.viferpar.app.mooc.steps.infraestructure.domain;

import com.viferpar.app.mooc.steps.domain.StepTitle;
import com.viferpar.app.shared.domain.WordMother;

public final class StepTitleMother {

  public static StepTitle create(String value) {
    return new StepTitle(value);
  }

  public static StepTitle random() {
    return create(WordMother.random());
  }

}
