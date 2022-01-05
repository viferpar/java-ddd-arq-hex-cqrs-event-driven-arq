package com.viferpar.app.mooc.courses_counter.infrastructure.controller;

import com.viferpar.app.shared.ApplicationTestCase;
import com.viferpar.app.shared.domain.course.CourseCreatedDomainEvent;
import org.junit.jupiter.api.Test;

final class CoursesCounterGetControllerTest extends ApplicationTestCase {

  @Test
  void shouldGetTheCounterWithOneCourse() throws Exception {
    givenISendEventsToTheBus(
        new CourseCreatedDomainEvent("8f34bc99-e0e2-4296-a008-75f51f03aeb4", "DDD en Java",
            "7 days")
    );

    assertResponse("/mooc/courses-counter", 200, "{'total': 1}");
  }

  @Test
  void shouldGetTheCounterWithMoreThanOneCourse() throws Exception {
    givenISendEventsToTheBus(
        new CourseCreatedDomainEvent("8f34bc99-e0e2-4296-a008-75f51f03aeb4", "DDD en Java",
            "7 days"),
        new CourseCreatedDomainEvent("3642f700-868a-4778-9317-a2d542d01785", "DDD en PHP",
            "6 days"),
        new CourseCreatedDomainEvent("92dd8402-69f3-4900-b569-3f2c2797065f", "DDD en Cobol",
            "10 years")
    );

    assertResponse("/mooc/courses-counter", 200, "{'total': 3}");
  }

  @Test
  void shouldGetTheCounterWithMoreThanOneCourseHavingDuplicatedEvents() throws Exception {
    givenISendEventsToTheBus(
        new CourseCreatedDomainEvent("8f34bc99-e0e2-4296-a008-75f51f03aeb4", "DDD en Java",
            "7 days"),
        new CourseCreatedDomainEvent("8f34bc99-e0e2-4296-a008-75f51f03aeb4", "DDD en Java",
            "7 days"),
        new CourseCreatedDomainEvent("8f34bc99-e0e2-4296-a008-75f51f03aeb4", "DDD en Java",
            "7 days"),
        new CourseCreatedDomainEvent("3642f700-868a-4778-9317-a2d542d01785", "DDD en PHP",
            "6 days"),
        new CourseCreatedDomainEvent("3642f700-868a-4778-9317-a2d542d01785", "DDD en PHP",
            "6 days"),
        new CourseCreatedDomainEvent("3642f700-868a-4778-9317-a2d542d01785", "DDD en PHP",
            "6 days"),
        new CourseCreatedDomainEvent("3642f700-868a-4778-9317-a2d542d01785", "DDD en PHP",
            "6 days"),
        new CourseCreatedDomainEvent("92dd8402-69f3-4900-b569-3f2c2797065f", "DDD en Cobol",
            "10 years"),
        new CourseCreatedDomainEvent("92dd8402-69f3-4900-b569-3f2c2797065f", "DDD en Cobol",
            "10 years")
    );

    assertResponse("/mooc/courses-counter", 200, "{'total': 3}");
  }

}
