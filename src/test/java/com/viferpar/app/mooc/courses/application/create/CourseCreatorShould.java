package com.viferpar.app.mooc.courses.application.create;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

import com.viferpar.app.mooc.courses.domain.Course;
import com.viferpar.app.mooc.courses.domain.CourseDuration;
import com.viferpar.app.mooc.courses.domain.CourseId;
import com.viferpar.app.mooc.courses.domain.CourseName;
import com.viferpar.app.mooc.courses.domain.CourseRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
final class CourseCreatorShould {

  @InjectMocks
  CourseCreator creator;

  @Mock
  CourseRepository repository;

  @Test
  void save_a_valid_course() throws Exception {
    Course course = new Course(new CourseId("d60a02db-67ef-4de8-875d-d3f2c91b2cd2"), new CourseName("some-name"),
        new CourseDuration("some-duration"));

    creator.create(new CreateCourseRequest(course.getId().getValue(), course.getName().getValue(), course.getDuration().getValue()));

    verify(repository, atLeastOnce()).save(course);
  }

}
