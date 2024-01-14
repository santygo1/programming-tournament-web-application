package ru.danilspirin.backend.model.enitiy;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import ru.danilspirin.backend.model.record.Role;

import java.util.Set;

@Table(name = "[user]")
@Entity
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserModel {

    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long id;

    String name;

    String email;

    String password;

    @Enumerated(EnumType.STRING)
    Role role;

    @ManyToMany
    @JoinTable(
            name = "tournament_user",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "tournament_id")
    )
    Set<TournamentModel> tournaments;
}
