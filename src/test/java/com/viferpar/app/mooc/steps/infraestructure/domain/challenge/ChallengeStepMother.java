package com.viferpar.app.mooc.steps.infraestructure.domain.challenge;

import com.viferpar.app.mooc.steps.domain.StepId;
import com.viferpar.app.mooc.steps.domain.StepTitle;
import com.viferpar.app.mooc.steps.domain.challenge.ChallengeStep;
import com.viferpar.app.mooc.steps.domain.challenge.ChallengeStepStatement;
import com.viferpar.app.mooc.steps.infraestructure.domain.StepIdMother;
import com.viferpar.app.mooc.steps.infraestructure.domain.StepTitleMother;

public final class ChallengeStepMother {

  public static ChallengeStep create(StepId id, StepTitle title, ChallengeStepStatement statement) {
    return new ChallengeStep(id, title, statement);
  }

  public static ChallengeStep random() {
    return create(StepIdMother.random(), StepTitleMother.random(),
        ChallengeStepStatementMother.random());
  }

}
