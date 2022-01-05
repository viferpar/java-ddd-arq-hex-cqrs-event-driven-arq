package com.viferpar.app.mooc.courses_counter.infraestructure.controller;

import com.viferpar.app.mooc.courses_counter.application.find.CoursesCounterFinder;
import com.viferpar.app.mooc.courses_counter.application.find.CoursesCounterResponse;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/mooc")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public final class CoursesCounterGetController {

  private final CoursesCounterFinder finder;

  @GetMapping("/courses-counter")
  public Map<String, Integer> index() {

    CoursesCounterResponse response = finder.find();

    Map<String, Integer> total = new HashMap<>();
    total.put("total", response.getTotal());

    return total;
  }

}
