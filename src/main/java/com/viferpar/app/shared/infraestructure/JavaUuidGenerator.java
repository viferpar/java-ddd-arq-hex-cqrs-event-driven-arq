package com.viferpar.app.shared.infraestructure;

import com.viferpar.app.shared.domain.UuidGenerator;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public final class JavaUuidGenerator implements UuidGenerator {

  @Override
  public String generate() {
    return UUID.randomUUID().toString();
  }
}
