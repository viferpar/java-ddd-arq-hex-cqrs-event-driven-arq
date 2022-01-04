package com.viferpar.app.mooc.courses.domain;

import com.viferpar.app.shared.domain.IntegerMother;
import com.viferpar.app.shared.domain.RandomElementPicker;

public final class CourseDurationMother {

  public static CourseDuration create(String value) {
    return new CourseDuration(value);
  }

  public static CourseDuration random() {
    return create(
        String.format(
            "%s %s",
            IntegerMother.random(),
            RandomElementPicker.from("years", "months", "days", "hours", "minutes", "seconds")
        )
    );
  }

}
