package dev.codenation.errorcentral.repository;

import dev.codenation.errorcentral.entity.Event;
import dev.codenation.errorcentral.enums.Level;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    Page<Event> findByLevel(Level level, Pageable pageable);

    Page<Event> findByDescriptionContainsIgnoreCase(String description, Pageable pageable);

    Page<Event> findBySourceContainsIgnoreCase(String source, Pageable pageable);

    Page<Event> findByDate(Date date, Pageable pageable);

    Page<Event> findByQuantity(Integer quantity, Pageable pageable);
}
