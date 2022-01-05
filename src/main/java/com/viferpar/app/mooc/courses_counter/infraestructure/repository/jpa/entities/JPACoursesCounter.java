package com.viferpar.app.mooc.courses_counter.infraestructure.repository.jpa.entities;

import com.vladmihalcea.hibernate.type.json.JsonStringType;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "CoursesCounter")
@Table(name = "courses_counter")
@TypeDef(name = "json", typeClass = JsonStringType.class)
public class JPACoursesCounter {

  @Id
  @Column(length = 36)
  private String id;

  private Integer total;

  @Type(type = "json")
  @Column(columnDefinition = "json")
  private List<String> existingCourses;

}
