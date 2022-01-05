package com.viferpar.app.mooc.courses_counter.domain;

import com.viferpar.app.shared.domain.IntValueObject;

public final class CoursesCounterTotal extends IntValueObject {

  public CoursesCounterTotal(Integer value) {
    super(value);
  }

  public CoursesCounterTotal() {
    super(null);
  }

  public static CoursesCounterTotal initialize() {
    return new CoursesCounterTotal(0);
  }

  public CoursesCounterTotal increment() {
    return new CoursesCounterTotal(getValue() + 1);
  }

}
