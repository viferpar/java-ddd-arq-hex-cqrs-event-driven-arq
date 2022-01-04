package com.viferpar.app.mooc.steps.infraestructure.repository.jpa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "Step")
@Table(name = "steps")
@Inheritance(strategy = InheritanceType.JOINED)
public class JPAStep {

  @Id
  @Column(length = 36)
  private String id;

  @Column(length = 155)
  private String title;

}
