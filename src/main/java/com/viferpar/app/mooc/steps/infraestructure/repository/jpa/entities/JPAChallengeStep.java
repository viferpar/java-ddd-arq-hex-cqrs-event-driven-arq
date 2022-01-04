package com.viferpar.app.mooc.steps.infraestructure.repository.jpa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "ChallengeStep")
@Table(name = "steps_challenges")
public class JPAChallengeStep extends JPAStep {

  @Column(columnDefinition = "TEXT")
  private String statement;

}
