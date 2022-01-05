package com.viferpar.app.mooc.courses.domain;

import com.viferpar.app.shared.domain.AgregateRoot;
import com.viferpar.app.shared.domain.course.CourseCreatedDomainEvent;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class Course extends AgregateRoot {

  private CourseId id;
  private CourseName name;
  private CourseDuration duration;

  public static Course create(CourseId id, CourseName name, CourseDuration duration) {
    Course course = new Course(id, name, duration);

    course.recordEvent(
        new CourseCreatedDomainEvent(id.getValue(), name.getValue(), duration.getValue()));

    return course;
  }

}
