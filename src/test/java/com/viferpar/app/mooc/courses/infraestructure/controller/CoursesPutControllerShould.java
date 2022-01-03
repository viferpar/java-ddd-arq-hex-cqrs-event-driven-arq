package com.viferpar.app.mooc.courses.infraestructure.controller;

import com.viferpar.app.shared.ApplicationTestCase;
import org.junit.jupiter.api.Test;

final class CoursesPutControllerShould extends ApplicationTestCase {

  @Test
  void create_a_valid_non_existing_course() throws Exception {
    assertRequestWithBody(
        "PUT",
        "/mooc/courses/1aab45ba-3c7a-4344-8936-78466eca77fa",
        "{\"name\": \"The best course\", \"duration\": \"5 hours\"}",
        201
    );
  }

}
