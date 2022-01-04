package com.viferpar.app.mooc.steps.domain.video;

import com.viferpar.app.mooc.steps.domain.Step;
import com.viferpar.app.mooc.steps.domain.StepId;
import com.viferpar.app.mooc.steps.domain.StepTitle;
import com.viferpar.app.shared.domain.VideoUrl;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
public final class VideoStep extends Step {

  private VideoUrl videoUrl;
  private VideoStepText text;

  public VideoStep(StepId id, StepTitle title, VideoUrl videoUrl, VideoStepText text) {
    super(id, title);
    this.videoUrl = videoUrl;
    this.text = text;
  }

  private VideoStep() {
    super(null, null);
    this.videoUrl = null;
    this.text = null;
  }

}
