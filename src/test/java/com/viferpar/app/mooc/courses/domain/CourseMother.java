package com.viferpar.app.mooc.courses.domain;

import com.viferpar.app.mooc.courses.application.create.CreateCourseRequest;

public final class CourseMother {

  public static Course create(CourseId id, CourseName name, CourseDuration duration) {
    return new Course(id, name, duration);
  }

  public static Course fromRequest(CreateCourseRequest request) {
    return create(
        CourseIdMother.create(request.getId()),
        CourseNameMother.create(request.getName()),
        CourseDurationMother.create(request.getDuration())
    );
  }

  public static Course random() {
    return create(CourseIdMother.random(), CourseNameMother.random(), CourseDurationMother.random());
  }

}
