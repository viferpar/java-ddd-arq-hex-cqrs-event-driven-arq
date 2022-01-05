package com.viferpar.app.mooc.courses.application.create;

import com.viferpar.app.mooc.courses.domain.Course;
import com.viferpar.app.mooc.courses.domain.CourseDuration;
import com.viferpar.app.mooc.courses.domain.CourseId;
import com.viferpar.app.mooc.courses.domain.CourseName;
import com.viferpar.app.mooc.courses.domain.CourseRepository;
import com.viferpar.app.shared.domain.bus.event.EventBus;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public final class CourseCreator {

  private final CourseRepository courseRepository;

  private final EventBus eventBus;

  public void create(CreateCourseRequest request) {
    CourseId id = new CourseId(request.getId());
    CourseName name = new CourseName(request.getName());
    CourseDuration duration = new CourseDuration(request.getDuration());

    Course course = Course.create(id, name, duration);

    courseRepository.save(course);
    eventBus.publish(course.pullDomainEvents());
  }

}
