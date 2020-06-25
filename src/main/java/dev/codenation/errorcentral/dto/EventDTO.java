package dev.codenation.errorcentral.dto;

import dev.codenation.errorcentral.enums.Level;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EventDTO {
    private Level level;
    private String description;
    private String source;
    private Date date;
    private Integer quantity;
}
