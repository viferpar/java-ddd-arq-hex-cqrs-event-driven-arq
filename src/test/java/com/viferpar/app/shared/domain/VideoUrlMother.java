package com.viferpar.app.shared.domain;

public final class VideoUrlMother {

  public static VideoUrl create(String value) {
    return new VideoUrl(value);
  }

  public static VideoUrl random() {
    return create(MotherCreator.random().internet().url());
  }

}
