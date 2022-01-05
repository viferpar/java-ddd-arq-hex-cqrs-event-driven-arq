package com.viferpar.app.mooc.courses_counter.domain;

import com.viferpar.app.mooc.courses.domain.CourseId;
import com.viferpar.app.mooc.courses.domain.CourseIdMother;
import com.viferpar.app.shared.domain.ListMother;
import java.util.ArrayList;
import java.util.List;

public final class CoursesCounterMother {

  public static CoursesCounter create(
      CoursesCounterId id,
      CoursesCounterTotal total,
      List<CourseId> existingCourses
  ) {
    return new CoursesCounter(id, total, existingCourses);
  }

  public static CoursesCounter withOne(CourseId courseId) {
    return create(CoursesCounterIdMother.random(), CoursesCounterTotalMother.one(),
        ListMother.one(courseId));
  }

  public static CoursesCounter random() {
    List<CourseId> existingCourses = ListMother.random(CourseIdMother::random);

    return create(
        CoursesCounterIdMother.random(),
        CoursesCounterTotalMother.create(existingCourses.size()),
        existingCourses
    );
  }

  public static CoursesCounter incrementing(CoursesCounter existingCounter, CourseId courseId) {
    List<CourseId> existingCourses = new ArrayList<>(existingCounter.getExistingCourses());
    existingCourses.add(courseId);

    return create(
        existingCounter.getId(),
        CoursesCounterTotalMother.create(existingCounter.getTotal().getValue() + 1),
        existingCourses
    );
  }
}
