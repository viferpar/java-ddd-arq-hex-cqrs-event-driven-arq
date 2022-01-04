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
@Entity(name = "VideoStep")
@Table(name = "steps_videos")
public class JPAVideoStep extends JPAStep {

  @Column(name = "url")
  private String videoUrl;

  @Column(columnDefinition = "TEXT")
  private String text;

}
