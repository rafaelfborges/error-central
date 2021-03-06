package dev.codenation.errorcentral.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    private Long id;
    private Level level;
    private String description;
    private String source;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date date;

    private Integer quantity;
}
