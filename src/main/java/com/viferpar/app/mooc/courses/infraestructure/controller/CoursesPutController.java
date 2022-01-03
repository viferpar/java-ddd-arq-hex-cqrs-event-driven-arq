package com.viferpar.app.mooc.courses.infraestructure.controller;

import com.viferpar.app.mooc.courses.application.create.CourseCreator;
import com.viferpar.app.mooc.courses.application.create.CreateCourseRequest;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/mooc")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public final class CoursesPutController {

  private final CourseCreator courseCreator;

  @PutMapping("courses/{id}")
  public ResponseEntity<String> create(@PathVariable String id, @RequestBody Request request) {
    courseCreator.create(new CreateCourseRequest(id, request.getName(), request.getDuration()));
    return new ResponseEntity(HttpStatus.CREATED);
  }

}

@Getter
@Setter
final class Request {

  private String name;
  private String duration;

}
