package com.viferpar.app.mooc.courses.infraestructure.repository;

import com.viferpar.app.mooc.courses.domain.Course;
import com.viferpar.app.mooc.courses.domain.CourseId;
import com.viferpar.app.mooc.courses.domain.CourseRepository;
import java.util.HashMap;
import java.util.Optional;

public final class InMemoryCourseRepository implements CourseRepository {

  private final HashMap<String, Course> courses = new HashMap<>();

  @Override
  public void save(Course course) {
    this.courses.put(course.getId().getValue(), course);
  }

  @Override
  public Optional<Course> search(CourseId id) {
    return Optional.ofNullable(courses.get(id.getValue()));
  }
}
