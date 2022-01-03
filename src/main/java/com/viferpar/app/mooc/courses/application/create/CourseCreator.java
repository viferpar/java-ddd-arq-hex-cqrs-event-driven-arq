package com.viferpar.app.mooc.courses.application.create;

import com.viferpar.app.mooc.courses.domain.Course;
import com.viferpar.app.mooc.courses.domain.CourseDuration;
import com.viferpar.app.mooc.courses.domain.CourseId;
import com.viferpar.app.mooc.courses.domain.CourseName;
import com.viferpar.app.mooc.courses.domain.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public final class CourseCreator {

  private final CourseRepository courseRepository;

  public void create(CreateCourseRequest request) {
    Course course = new Course(new CourseId(request.getId()), new CourseName(request.getName()), new CourseDuration(request.getDuration()));

    courseRepository.save(course);
  }

}
