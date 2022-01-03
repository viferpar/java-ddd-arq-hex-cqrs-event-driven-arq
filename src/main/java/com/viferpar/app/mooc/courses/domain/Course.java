package com.viferpar.app.mooc.courses.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {

  private CourseId id;
  private CourseName name;
  private CourseDuration duration;

}
