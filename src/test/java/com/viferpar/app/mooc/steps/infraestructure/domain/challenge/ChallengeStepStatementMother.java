package com.viferpar.app.mooc.steps.infraestructure.domain.challenge;

import com.viferpar.app.mooc.steps.domain.challenge.ChallengeStepStatement;
import com.viferpar.app.shared.domain.WordMother;

public final class ChallengeStepStatementMother {

  public static ChallengeStepStatement create(String value) {
    return new ChallengeStepStatement(value);
  }

  public static ChallengeStepStatement random() {
    return create(WordMother.random());
  }

}
