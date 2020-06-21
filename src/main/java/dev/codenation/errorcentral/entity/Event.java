package dev.codenation.errorcentral.entity;

import dev.codenation.errorcentral.enums.Level;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @NotNull
    @NotBlank(message = "Event level is required")
    private Level level;

    @Column
    @NotNull
    @NotBlank(message = "Event description is required")
    private String description;

    @Column
    @NotNull
    @NotBlank(message = "Event log is required")
    private String log;

    @Column
    @NotNull
    @NotBlank(message = "Source of event is required")
    @Size(max = 100)
    private String source;

    @Temporal(TemporalType.DATE)
    @NotNull
    @NotBlank(message = "Event date is required")
    private Date date;

    @Column
    @NotNull
    @NotBlank(message = "Quantity of same event is required")
    private Integer quantity;
}
