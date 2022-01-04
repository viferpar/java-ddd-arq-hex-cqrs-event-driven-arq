package com.viferpar.app.mooc.courses.infraestructure.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import com.viferpar.app.mooc.courses.domain.Course;
import com.viferpar.app.mooc.courses.domain.CourseIdMother;
import com.viferpar.app.mooc.courses.domain.CourseMother;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
final class InMemoryCourseRepositoryTest {

  @Autowired
  InMemoryCourseRepository repository;

  @Test
  void shouldSaveAValidCourse() {
    Course course = CourseMother.random();

    repository.save(course);
  }

  @Test
  void shouldSearchAnExistingCourse() {
    Course course = CourseMother.random();

    repository.save(course);

    assertEquals(Optional.of(course), repository.search(course.getId()));
  }

  @Test
  void shouldNotFindANonExistingCourse() {
    assertFalse(repository.search(CourseIdMother.random()).isPresent());
  }

}
