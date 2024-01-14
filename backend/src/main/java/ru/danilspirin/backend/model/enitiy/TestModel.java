package ru.danilspirin.backend.model.enitiy;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "test")
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TestModel {

    @Column(name = "test_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long id;

    String input;

    String output;

    @JoinColumn(name = "task_id")
    @ManyToOne
    TaskModel taskModel;
}
