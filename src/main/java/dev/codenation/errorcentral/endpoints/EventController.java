package dev.codenation.errorcentral.endpoints;

import dev.codenation.errorcentral.entity.Event;
import dev.codenation.errorcentral.exceptions.ResourceNotFoundException;
import dev.codenation.errorcentral.service.impl.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/api/event")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public List<Event> findAll() {
        return this.eventService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Event> findById(@PathVariable Long id) {
        return ResponseEntity.ok(eventService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Event")));
    }
}
