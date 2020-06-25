package dev.codenation.errorcentral.service.impl;

import dev.codenation.errorcentral.dto.EventDTO;
import dev.codenation.errorcentral.entity.Event;
import dev.codenation.errorcentral.enums.Level;
import dev.codenation.errorcentral.mappers.EventMapper;
import dev.codenation.errorcentral.repository.EventRepository;
import dev.codenation.errorcentral.service.interfaces.EventServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EventService implements EventServiceInterface {

    private final EventRepository eventRepository;
    private final EventMapper eventMapper;

    @Override
    public Event save(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public Optional<Event> findById(Long id) {
        return eventRepository.findById(id);
    }

    @Override
    public Page<EventDTO> findAll(Pageable pageable) {
        Page<Event> events = eventRepository.findAll(pageable);
        return new PageImpl<>(eventMapper.map(events.getContent()), events.getPageable(), events.getTotalElements());
    }

    @Override
    public Page<EventDTO> findByLevel(Level level, Pageable pageable) {
        Page<Event> events = eventRepository.findByLevel(level, pageable);
        return new PageImpl<>(eventMapper.map(events.getContent()), events.getPageable(), events.getTotalElements());
    }

    @Override
    public Page<EventDTO> findByDescription(String description, Pageable pageable) {
        Page<Event> events = eventRepository.findByDescriptionContainsIgnoreCase(description, pageable);
        return new PageImpl<>(eventMapper.map(events.getContent()), events.getPageable(), events.getTotalElements());
    }

    @Override
    public Page<EventDTO> findBySource(String source, Pageable pageable) {
        Page<Event> events = eventRepository.findBySourceContainsIgnoreCase(source, pageable);
        return new PageImpl<>(eventMapper.map(events.getContent()), events.getPageable(), events.getTotalElements());
    }

    @Override
    public Page<EventDTO> findByDate(Date date, Pageable pageable) {
        Page<Event> events = eventRepository.findByDate(date, pageable);
        return new PageImpl<>(eventMapper.map(events.getContent()), events.getPageable(), events.getTotalElements());
    }

    @Override
    public Page<EventDTO> findByQuantity(Integer quantity, Pageable pageable) {
        Page<Event> events = eventRepository.findByQuantity(quantity, pageable);
        return new PageImpl<>(eventMapper.map(events.getContent()), events.getPageable(), events.getTotalElements());
    }

    @Override
    public void deleteById(Long id) {
        eventRepository.deleteById(id);
    }
}
