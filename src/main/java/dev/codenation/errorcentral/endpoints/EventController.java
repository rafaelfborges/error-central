package dev.codenation.errorcentral.endpoints;

import dev.codenation.errorcentral.dto.EventDTO;
import dev.codenation.errorcentral.entity.Event;
import dev.codenation.errorcentral.enums.Level;
import dev.codenation.errorcentral.exceptions.ResourceNotFoundException;
import dev.codenation.errorcentral.service.impl.EventService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springdoc.core.converters.models.PageableAsQueryParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Parameter;

import lombok.AllArgsConstructor;

import javax.validation.Valid;
import java.util.Date;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/api/event")
public class EventController {

    private final EventService eventService;

    @PostMapping
    public ResponseEntity<Event> create(@Valid @RequestBody Event event) {
        return new ResponseEntity<>(this.eventService.save(event), HttpStatus.CREATED);
    }

    @GetMapping
    @PageableAsQueryParam
    @Operation(description = "Buscar todos os eventos")
    @ApiResponse(description = "Success", responseCode = "200", content = @Content(mediaType = "application/json"))
    public Page<EventDTO> findAll(
            @RequestParam(value = "level", required = false) Level level,
            @RequestParam(value = "description", required = false) String description,
            @RequestParam(value = "source", required = false) String source,
            @RequestParam(value = "date", required = false) Date date,
            @RequestParam(value = "quantity", required = false) Integer quantity,
            @Parameter(hidden = true) @PageableDefault(size = 5, page = 0, sort = "id") Pageable pageable) {

        if(level != null)
            return eventService.findByLevel(level, pageable);
        if(description != null)
            return eventService.findByDescription(description, pageable);
        if(source != null)
            return eventService.findBySource(source, pageable);
        if(date != null)
            return eventService.findByDate(date, pageable);
        if(quantity != null)
            return eventService.findByQuantity(quantity, pageable);

        return eventService.findAll(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Event> findById(@PathVariable Long id) {
        return ResponseEntity.ok(eventService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Event")));
    }
}
