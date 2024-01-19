package ru.danilspirin.backend.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Table(name = "[user]")
@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {

    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long id;

    String username;

    String email;

    @Enumerated(EnumType.STRING)
    Role role;

    @ManyToMany
    @JoinTable(
            name = "tournament_user",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "tournament_id")
    )
    Set<Tournament> tournaments;

    @OneToMany(mappedBy = "author")
    Set<Task> tasks;
}
