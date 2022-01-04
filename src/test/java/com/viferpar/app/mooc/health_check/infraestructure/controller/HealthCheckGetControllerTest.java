package com.viferpar.app.mooc.health_check.infraestructure.controller;

import com.viferpar.app.shared.ApplicationTestCase;
import org.junit.jupiter.api.Test;

final class HealthCheckGetControllerTest extends ApplicationTestCase {

  @Test
  void shouldCheckTheAppIsWorkingOk() throws Exception {
    assertResponse("/mooc/health-check", 200, "{'application':'mooc_backend','status':'ok'}");
  }

}
