package ru.danilspirin.backend.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import ru.danilspirin.backend.model.records.Category;

import java.util.List;

@Entity
@Table(name = "task")
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Task {

    @Column(name = "task_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long id;

    String title;

    String taskCondition; // Текст для задачи

    @Enumerated(EnumType.STRING)
    Category category;

    @OneToMany(mappedBy = "task")
    List<Test> tests;

}
