package ru.danilspirin.backend.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.Type;
import ru.danilspirin.backend.model.records.Category;

import java.time.LocalDate;
import java.util.Set;

@Table(name = "tournament")
@Entity
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Tournament {

    @Column(name = "tournament_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long id;

    @Column(nullable = false)
    String title;

    @Column(length = 65535,columnDefinition="Text")
    String text;

    @Column(nullable = false)
    LocalDate startDate;

    @Column(nullable = false)
    LocalDate finishDate;

    @Enumerated(EnumType.STRING)
    Category category;

    @ManyToMany(mappedBy = "tournaments")
    Set<User> users;

    @ManyToMany
    @JoinTable(
            name = "tournament_task",
            joinColumns = @JoinColumn(name = "tournament_id"),
            inverseJoinColumns = @JoinColumn(name = "task_id")
    )
    Set<Task> tasks;
}
