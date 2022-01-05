package com.viferpar.app.mooc.courses_counter.application.increment;

import com.viferpar.app.mooc.courses.domain.CourseId;
import com.viferpar.app.shared.domain.course.CourseCreatedDomainEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public final class IncrementCoursesCounterOnCourseCreated {

  private final CoursesCounterIncrementer incrementer;

  @EventListener
  public void on(CourseCreatedDomainEvent event) {
    CourseId courseId = new CourseId(event.aggregateId());

    incrementer.increment(courseId);
  }

}
