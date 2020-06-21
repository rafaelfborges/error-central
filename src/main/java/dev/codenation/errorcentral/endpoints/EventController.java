package dev.codenation.errorcentral.endpoints;

import dev.codenation.errorcentral.entity.Event;
import dev.codenation.errorcentral.service.impl.EventService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/eventlog")
public class EventController {

    private EventService eventService;

    @GetMapping("/{id}")
    public Event findById(@PathVariable Long id) {
        return eventService.findById(id).get();
    }
}
