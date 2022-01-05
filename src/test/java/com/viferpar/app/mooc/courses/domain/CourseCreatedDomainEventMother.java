package com.viferpar.app.mooc.courses.domain;

import com.viferpar.app.shared.domain.course.CourseCreatedDomainEvent;

public final class CourseCreatedDomainEventMother {

  public static CourseCreatedDomainEvent create(CourseId id, CourseName name,
      CourseDuration duration) {
    return new CourseCreatedDomainEvent(id.getValue(), name.getValue(), duration.getValue());
  }

  public static CourseCreatedDomainEvent fromCourse(Course course) {
    return create(course.getId(), course.getName(), course.getDuration());
  }

  public static CourseCreatedDomainEvent random() {
    return create(CourseIdMother.random(), CourseNameMother.random(),
        CourseDurationMother.random());
  }

}
