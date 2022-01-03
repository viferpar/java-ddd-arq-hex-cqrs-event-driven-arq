package com.viferpar.app.mooc.courses.infraestructure.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import com.viferpar.app.mooc.courses.domain.Course;
import com.viferpar.app.mooc.courses.domain.CourseDuration;
import com.viferpar.app.mooc.courses.domain.CourseId;
import com.viferpar.app.mooc.courses.domain.CourseName;
import com.viferpar.app.mooc.courses.infraestructure.repository.InMemoryCourseRepository;
import java.util.Optional;
import org.junit.jupiter.api.Test;

final class InMemoryCourseRepositoryShould {

  @Test
  void save_a_valid_course() throws Exception {
    InMemoryCourseRepository repository = new InMemoryCourseRepository();

    Course course = new Course(new CourseId("d60a02db-67ef-4de8-875d-d3f2c91b2cd2"), new CourseName("some-name"),
        new CourseDuration("some-duration"));

    repository.save(course);
  }

  @Test
  void search_an_existing_course() {
    InMemoryCourseRepository repository = new InMemoryCourseRepository();

    Course course = new Course(new CourseId("d60a02db-67ef-4de8-875d-d3f2c91b2cd2"), new CourseName("some-name"),
        new CourseDuration("some-duration"));

    repository.save(course);

    assertEquals(Optional.of(course), repository.search(course.getId()));
  }

  @Test
  void not_find_a_non_existing_course() {
    InMemoryCourseRepository repository = new InMemoryCourseRepository();

    assertFalse(repository.search(new CourseId("7099a709-751f-4618-becd-55b2e86903a2")).isPresent());
  }

}
