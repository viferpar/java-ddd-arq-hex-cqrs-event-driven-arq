package com.viferpar.app.mooc.steps.infraestructure.domain.video;

import com.viferpar.app.mooc.steps.domain.video.VideoStepText;
import com.viferpar.app.shared.domain.WordMother;

public final class VideoStepTextMother {

  public static VideoStepText create(String value) {
    return new VideoStepText(value);
  }

  public static VideoStepText random() {
    return create(WordMother.random());
  }

}
