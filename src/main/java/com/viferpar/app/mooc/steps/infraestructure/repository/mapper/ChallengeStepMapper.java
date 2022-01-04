package com.viferpar.app.mooc.steps.infraestructure.repository.mapper;

import com.viferpar.app.mooc.steps.domain.challenge.ChallengeStep;
import com.viferpar.app.mooc.steps.infraestructure.repository.jpa.entities.JPAChallengeStep;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ChallengeStepMapper {

  @Mapping(target = "id", source = "id.value")
  @Mapping(target = "title", source = "title.value")
  @Mapping(target = "statement", source = "statement.value")
  JPAChallengeStep toJPAEntity(ChallengeStep domainModel);

  @InheritInverseConfiguration
  ChallengeStep toDomainModel(JPAChallengeStep jpaEntity);

}
