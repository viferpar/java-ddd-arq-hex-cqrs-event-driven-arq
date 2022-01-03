package com.viferpar.app.mooc.health_check.infraestructure.controller;

import static org.junit.jupiter.api.Assertions.*;

import com.viferpar.app.shared.ApplicationTestCase;
import org.junit.jupiter.api.Test;

final class HealthCheckGetControllerShould extends ApplicationTestCase {

  @Test
  void check_the_app_is_working_ok() throws Exception {
    assertResponse("/mooc/health-check", 200, "{'application':'mooc_backend','status':'ok'}");
  }

}
