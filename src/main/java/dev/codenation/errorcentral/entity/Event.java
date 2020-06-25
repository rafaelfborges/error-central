package dev.codenation.errorcentral.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import dev.codenation.errorcentral.enums.Level;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
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

    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date date;

    @Column
    @PositiveOrZero
    @NotNull
    private Integer quantity;
}
