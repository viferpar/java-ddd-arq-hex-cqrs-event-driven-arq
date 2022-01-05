package com.viferpar.app.mooc.courses.application.create;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

import com.viferpar.app.mooc.courses.domain.Course;
import com.viferpar.app.mooc.courses.domain.CourseCreatedDomainEventMother;
import com.viferpar.app.mooc.courses.domain.CourseMother;
import com.viferpar.app.mooc.courses.domain.CourseRepository;
import com.viferpar.app.shared.domain.bus.event.EventBus;
import com.viferpar.app.shared.domain.course.CourseCreatedDomainEvent;
import java.util.Collections;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
final class CourseCreatorTest {

  @InjectMocks
  CourseCreator creator;

  @Mock
  CourseRepository repository;

  @Mock
  EventBus eventBus;

  @Test
  void shouldCreateAValidCourse() {

    CreateCourseRequest request = CreateCourseRequestMother.random();

    Course course = CourseMother.fromRequest(request);
    CourseCreatedDomainEvent domainEvent = CourseCreatedDomainEventMother.fromCourse(course);

    creator.create(request);

    verify(repository, atLeastOnce()).save(course);
    verify(eventBus, atLeastOnce()).publish(Collections.singletonList(domainEvent));

  }

}
