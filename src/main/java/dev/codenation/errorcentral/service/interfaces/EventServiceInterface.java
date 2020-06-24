package dev.codenation.errorcentral.service.interfaces;

import dev.codenation.errorcentral.entity.Event;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface EventServiceInterface extends ServiceInterface<Event> {

    List<Event> findAll(Pageable pageable);

    Optional<Event> findById(Long id);

    Event save(Event event);
}
