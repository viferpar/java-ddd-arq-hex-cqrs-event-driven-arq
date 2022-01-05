package com.viferpar.app.shared.domain;

import com.viferpar.app.shared.domain.bus.event.DomainEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class AgregateRoot {

  private List<DomainEvent> domainEvents = new ArrayList<>();

  public final List<DomainEvent> pullDomainEvents() {
    List<DomainEvent> events = domainEvents;

    domainEvents = Collections.emptyList();

    return events;
  }

  protected final void recordEvent(DomainEvent event) {
    domainEvents.add(event);
  }

}
