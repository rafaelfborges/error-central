package dev.codenation.errorcentral.service.interfaces;

import dev.codenation.errorcentral.entity.Event;

import java.util.Optional;

public interface EventServiceInterface extends ServiceInterface<Event> {

    Optional<Event> findById(Long eventId);
}
