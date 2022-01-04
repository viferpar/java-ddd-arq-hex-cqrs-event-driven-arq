package com.viferpar.app.mooc.courses.infraestructure.controller;

import com.viferpar.app.shared.ApplicationTestCase;
import org.junit.jupiter.api.Test;

final class CoursesPutControllerTest extends ApplicationTestCase {

  @Test
  void shouldCreateAValidNonExistingCourse() throws Exception {
    assertRequestWithBody(
        "PUT",
        "/mooc/courses/1aab45ba-3c7a-4344-8936-78466eca77fa",
        "{\"name\": \"The best course\", \"duration\": \"5 hours\"}",
        201
    );
  }

}
