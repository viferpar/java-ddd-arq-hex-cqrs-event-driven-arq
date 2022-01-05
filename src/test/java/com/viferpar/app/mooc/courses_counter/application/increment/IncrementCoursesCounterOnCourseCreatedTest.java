package com.viferpar.app.mooc.courses_counter.application.increment;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.viferpar.app.mooc.courses.domain.CourseCreatedDomainEventMother;
import com.viferpar.app.mooc.courses.domain.CourseId;
import com.viferpar.app.mooc.courses.domain.CourseIdMother;
import com.viferpar.app.mooc.courses_counter.domain.CoursesCounter;
import com.viferpar.app.mooc.courses_counter.domain.CoursesCounterMother;
import com.viferpar.app.mooc.courses_counter.domain.CoursesCounterRepository;
import com.viferpar.app.shared.domain.UuidGenerator;
import com.viferpar.app.shared.domain.course.CourseCreatedDomainEvent;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
final class IncrementCoursesCounterOnCourseCreatedTest {

  @Mock
  CoursesCounterRepository repository;

  @Mock
  UuidGenerator uuidGenerator;

  IncrementCoursesCounterOnCourseCreated subscriber;

  @BeforeEach
  void setUp() {
    subscriber = new IncrementCoursesCounterOnCourseCreated(
        new CoursesCounterIncrementer(repository, uuidGenerator));
  }

  @Test
  void itShouldInitializeANewCounter() {
    CourseCreatedDomainEvent event = CourseCreatedDomainEventMother.random();

    CourseId courseId = CourseIdMother.create(event.aggregateId());
    CoursesCounter newCounter = CoursesCounterMother.withOne(courseId);

    when(repository.search()).thenReturn(Optional.empty());
    when(uuidGenerator.generate()).thenReturn(newCounter.getId().getValue());

    subscriber.on(event);

    verify(repository, atLeastOnce()).save(newCounter);
  }

  @Test
  void itShouldIncrementAnExistingCounter() {
    CourseCreatedDomainEvent event = CourseCreatedDomainEventMother.random();

    CourseId courseId = CourseIdMother.create(event.aggregateId());
    CoursesCounter existingCounter = CoursesCounterMother.random();
    CoursesCounter incrementedCounter = CoursesCounterMother.incrementing(existingCounter,
        courseId);

    Mockito.when(repository.search()).thenReturn(Optional.of(existingCounter));

    subscriber.on(event);

    verify(repository, atLeastOnce()).save(incrementedCounter);
  }

  @Test
  void itShouldNotIncrementAnAlreadyIncrementedCourse() {
    CourseCreatedDomainEvent event = CourseCreatedDomainEventMother.random();

    CourseId courseId = CourseIdMother.create(event.aggregateId());
    CoursesCounter existingCounter = CoursesCounterMother.withOne(courseId);

    when(repository.search()).thenReturn(Optional.of(existingCounter));

    subscriber.on(event);
  }
}
