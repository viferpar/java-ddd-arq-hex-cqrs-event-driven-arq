package com.viferpar.app.mooc.steps.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class Step {

  private StepId id;
  private StepTitle title;

}
