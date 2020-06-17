package dev.codenation.errorcentral.repository;

import dev.codenation.errorcentral.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {

}
