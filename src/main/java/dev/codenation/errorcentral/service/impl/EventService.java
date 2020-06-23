package dev.codenation.errorcentral.service.impl;

import dev.codenation.errorcentral.entity.Event;
import dev.codenation.errorcentral.repository.EventRepository;
import dev.codenation.errorcentral.service.interfaces.EventServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService implements EventServiceInterface {

    @Autowired
    private EventRepository eventRepository;

    @Override
    public Optional<Event> findById(Long id) {
        return eventRepository.findById(id);
    }

    @Override
    public List<Event> findAll() {
        return eventRepository.findAll();
    }
}
