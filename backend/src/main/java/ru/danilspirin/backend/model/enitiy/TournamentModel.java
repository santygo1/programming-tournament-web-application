package ru.danilspirin.backend.model.enitiy;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Set;

@Table(name = "tournament")
@Entity
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TournamentModel {

    @Column(name = "tournament_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long id;

    String title;

    LocalDate date;

    int durationMinutes;


    @ManyToMany(mappedBy = "tournaments")
    Set<UserModel> users;

    @ManyToMany
    @JoinTable(
            name = "tournament_task",
            joinColumns = @JoinColumn(name = "tournament_id"),
            inverseJoinColumns = @JoinColumn(name = "task_id")
    )
    Set<TaskModel> tasks;
}
