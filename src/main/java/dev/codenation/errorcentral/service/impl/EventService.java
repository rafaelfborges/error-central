package dev.codenation.errorcentral.service.impl;

import dev.codenation.errorcentral.entity.Event;
import dev.codenation.errorcentral.repository.EventRepository;
import dev.codenation.errorcentral.service.interfaces.EventServiceInterface;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EventService implements EventServiceInterface {

    private EventRepository eventRepository;

    @Override
    public Optional<Event> findById(Long eventId) {
        return Optional.empty();
    }
}
