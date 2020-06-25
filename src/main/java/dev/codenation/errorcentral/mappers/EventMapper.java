package dev.codenation.errorcentral.mappers;

import dev.codenation.errorcentral.dto.EventDTO;
import dev.codenation.errorcentral.entity.Event;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EventMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "level", target = "level"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "source", target = "source"),
            @Mapping(source = "date", target = "date", dateFormat = "yyyy-MM-dd HH:mm"),
            @Mapping(source = "quantity", target = "quantity")
    })
    EventDTO map(Event event);

    List<EventDTO> map(List<Event> events);
}
