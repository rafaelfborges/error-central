package dev.codenation.errorcentral.entity;

import dev.codenation.errorcentral.enums.Level;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Level level;

    @Column
    @NotNull
    private String description;

    @Column
    @NotNull
    @NotBlank
    private String log;

    @Column
    @NotNull
    @NotBlank
    @Size(max = 100)
    private String source;

    @Temporal(TemporalType.DATE)
    @NotNull
    private Date date;

    @Column
    @Min(value = 0)
    @NotNull
    private Integer quantity;
}
