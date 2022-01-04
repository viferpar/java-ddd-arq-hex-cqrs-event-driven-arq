package com.viferpar.app.mooc.steps.domain.challenge;

import com.viferpar.app.mooc.steps.domain.Step;
import com.viferpar.app.mooc.steps.domain.StepId;
import com.viferpar.app.mooc.steps.domain.StepTitle;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
public final class ChallengeStep extends Step {

  private ChallengeStepStatement statement;

  public ChallengeStep(StepId id, StepTitle title, ChallengeStepStatement statement) {
    super(id, title);
    this.statement = statement;
  }

}
