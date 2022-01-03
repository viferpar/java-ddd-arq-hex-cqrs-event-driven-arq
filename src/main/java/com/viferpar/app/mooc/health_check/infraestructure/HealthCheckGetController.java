package com.viferpar.app.mooc.health_check.infraestructure;

import java.util.HashMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/mooc")
public final class HealthCheckGetController {

  @GetMapping("/health-check")
  public HashMap<String, String> index() {
    HashMap<String, String> status = new HashMap<>();
    status.put("application", "mooc_backend");
    status.put("status", "ok");

    return status;
  }

}
