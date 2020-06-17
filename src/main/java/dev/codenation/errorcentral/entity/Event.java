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
    private Level level;

    @Column
    @NotNull
    @NotBlank
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
    @NotBlank
    private Date date;

    @Column
    @NotNull
    @NotBlank
    private Integer amount;
}
