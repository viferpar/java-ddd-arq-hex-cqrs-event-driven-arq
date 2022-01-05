package com.viferpar.app.mooc.courses_counter.domain;

import com.viferpar.app.shared.domain.Identifier;

public final class CoursesCounterId extends Identifier {

  public CoursesCounterId(String value) {
    super(value);
  }

  private CoursesCounterId() {
    super(null);
  }
}
