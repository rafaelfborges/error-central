package dev.codenation.errorcentral.endpoints;

import dev.codenation.errorcentral.dto.EventDTO;
import dev.codenation.errorcentral.entity.Event;
import dev.codenation.errorcentral.exceptions.ResourceNotFoundException;
import dev.codenation.errorcentral.mappers.EventMapper;
import dev.codenation.errorcentral.service.impl.EventService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/api/event")
public class EventController {

    private final EventService eventService;
    private final EventMapper eventMapper;

    @PostMapping
    public ResponseEntity<Event> create(@Valid @RequestBody Event event) {
        return new ResponseEntity<>(this.eventService.save(event), HttpStatus.CREATED);
    }

    @GetMapping
    public List<EventDTO> findAll() {
        return eventMapper.map(eventService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Event> findById(@PathVariable Long id) {
        return ResponseEntity.ok(eventService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Event")));
    }
}
