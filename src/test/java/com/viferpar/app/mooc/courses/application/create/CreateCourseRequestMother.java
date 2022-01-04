package com.viferpar.app.mooc.courses.application.create;

import com.viferpar.app.mooc.courses.domain.CourseDuration;
import com.viferpar.app.mooc.courses.domain.CourseDurationMother;
import com.viferpar.app.mooc.courses.domain.CourseId;
import com.viferpar.app.mooc.courses.domain.CourseIdMother;
import com.viferpar.app.mooc.courses.domain.CourseName;
import com.viferpar.app.mooc.courses.domain.CourseNameMother;

public final class CreateCourseRequestMother {

  public static CreateCourseRequest create (CourseId id, CourseName name, CourseDuration duration) {
      return new CreateCourseRequest(id.getValue(), name.getValue(), duration.getValue());
  }

  public static CreateCourseRequest random() {
      return create(CourseIdMother.random(), CourseNameMother.random(), CourseDurationMother.random());
  }

}
