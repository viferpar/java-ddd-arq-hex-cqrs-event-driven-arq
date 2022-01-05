package com.viferpar.app.mooc.courses.infraestructure.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import com.viferpar.app.mooc.courses.domain.Course;
import com.viferpar.app.mooc.courses.domain.CourseIdMother;
import com.viferpar.app.mooc.courses.domain.CourseMother;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.transaction.annotation.Transactional;

@Transactional
final class InMemoryCourseRepositoryTest {

  InMemoryCourseRepository repository;

  @BeforeEach
  void setUp() {
    repository = new InMemoryCourseRepository();
  }

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
