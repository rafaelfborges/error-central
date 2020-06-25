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

    @Operation(description = "Cria um novo evento")
    @ApiResponse(description = "Success", responseCode = "201", content = @Content(mediaType = "application/json"))
    @PostMapping
    public ResponseEntity<Event> create(@Valid @RequestBody Event event) {
        return new ResponseEntity<>(this.eventService.save(event), HttpStatus.CREATED);
    }

    @GetMapping
    @Operation(description = "Lista todos os eventos")
    @PageableAsQueryParam
    @ApiResponse(description = "Success", responseCode = "200", content = @Content(mediaType = "application/json"))
    public Page<EventDTO> findAll(
            @RequestParam(value = "level", required = false) Level level,
            @RequestParam(value = "description", required = false) String description,
            @RequestParam(value = "source", required = false) String source,
            @RequestParam(value = "quantity", required = false) Integer quantity,
            @Parameter(hidden = true) @PageableDefault(page = 0, size = 5, sort = "id") Pageable pageable) {

        if(level != null)
            return this.eventService.findByLevel(level, pageable);
        if(description != null)
            return this.eventService.findByDescription(description, pageable);
        if(source != null)
            return this.eventService.findBySource(source, pageable);
        if(quantity != null)
            return this.eventService.findByQuantity(quantity, pageable);

        return this.eventService.findAll(pageable);
    }

    @Operation(description = "Lista um evento por id")
    @ApiResponse(description = "Success", responseCode = "200", content = @Content(mediaType = "application/json"))
    @GetMapping("/{id}")
    public ResponseEntity<Event> findById(@PathVariable Long id) {
        return ResponseEntity.ok(eventService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Event")));
    }

    @Operation(description = "Deleta um evento por id")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.eventService.deleteById(id);
    }
}
