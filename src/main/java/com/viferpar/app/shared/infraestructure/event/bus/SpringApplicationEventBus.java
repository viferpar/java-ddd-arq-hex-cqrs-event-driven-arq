package com.viferpar.app.shared.infraestructure.event.bus;

import com.viferpar.app.shared.domain.bus.event.DomainEvent;
import com.viferpar.app.shared.domain.bus.event.EventBus;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SpringApplicationEventBus implements EventBus {

  private final ApplicationEventPublisher publisher;

  @Override
  public void publish(final List<DomainEvent> events) {
    events.forEach(this::publish);
  }

  private void publish(final DomainEvent event) {
    this.publisher.publishEvent(event);
  }
}
