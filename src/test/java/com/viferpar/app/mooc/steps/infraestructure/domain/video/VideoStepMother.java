package com.viferpar.app.mooc.steps.infraestructure.domain.video;

import com.viferpar.app.mooc.steps.domain.StepId;
import com.viferpar.app.mooc.steps.domain.StepTitle;
import com.viferpar.app.mooc.steps.domain.video.VideoStep;
import com.viferpar.app.mooc.steps.domain.video.VideoStepText;
import com.viferpar.app.mooc.steps.infraestructure.domain.StepIdMother;
import com.viferpar.app.mooc.steps.infraestructure.domain.StepTitleMother;
import com.viferpar.app.shared.domain.VideoUrl;
import com.viferpar.app.shared.domain.VideoUrlMother;

public final class VideoStepMother {

  public static VideoStep create(StepId id, StepTitle title, VideoUrl videoUrl,
      VideoStepText text) {
    return new VideoStep(id, title, videoUrl, text);
  }

  public static VideoStep random() {
    return create(
        StepIdMother.random(),
        StepTitleMother.random(),
        VideoUrlMother.random(),
        VideoStepTextMother.random()
    );
  }

}
