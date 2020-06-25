package dev.codenation.errorcentral.service.interfaces;

import dev.codenation.errorcentral.dto.EventDTO;
import dev.codenation.errorcentral.entity.Event;
import dev.codenation.errorcentral.enums.Level;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.Optional;


public interface EventServiceInterface extends ServiceInterface<Event> {

    Event save(Event event);

    Page<EventDTO> findAll(Pageable pageable);

    Page<EventDTO> findByLevel(Level level, Pageable pageable);

    Page<EventDTO> findByDescription(String description, Pageable pageable);

    Page<EventDTO> findBySource(String source, Pageable pageable);

    Page<EventDTO> findByDate(Date date, Pageable pageable);

    Page<EventDTO> findByQuantity(Integer quantity, Pageable pageable);

    Optional<Event> findById(Long id);

    void deleteById(Long id);
}
