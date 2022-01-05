package com.viferpar.app.mooc.courses_counter.domain;

import com.viferpar.app.mooc.courses.domain.CourseId;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public final class CoursesCounter {

  private CoursesCounterId id;
  private CoursesCounterTotal total;
  private List<CourseId> existingCourses;

  public static CoursesCounter initialize(String id) {
    return new CoursesCounter(new CoursesCounterId(id), CoursesCounterTotal.initialize(),
        new ArrayList<>());
  }

  public boolean hasIncremented(CourseId id) {
    return existingCourses.contains(id);
  }

  public void increment(CourseId id) {
    total = total.increment();
    existingCourses.add(id);
  }

}
