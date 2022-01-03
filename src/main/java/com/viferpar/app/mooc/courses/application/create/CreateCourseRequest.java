package com.viferpar.app.mooc.courses.application.create;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCourseRequest {

  private String id;
  private String name;
  private String duration;

}
