package com.viferpar.app.shared.domain.bus.event;

import java.util.List;

public interface EventBus {

  void publish(final List<DomainEvent> events);
}
