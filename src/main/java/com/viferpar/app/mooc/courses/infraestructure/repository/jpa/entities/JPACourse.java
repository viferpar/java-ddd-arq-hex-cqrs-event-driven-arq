package com.viferpar.app.mooc.courses.infraestructure.repository.jpa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "Course")
@Table(name = "courses")
public class JPACourse {

  @Id
  @Column(length = 36)
  private String id;

  private String name;

  private String duration;

}
