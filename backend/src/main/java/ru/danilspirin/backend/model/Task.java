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

    @Column(name = "time_requirements", columnDefinition = "int default 0")
    int timeRequirementsInMinutes;

    @Column(name = "memory_requirements", columnDefinition = "int default 0")
    int memoryRequirementsInMb;

    @Column(columnDefinition = "text", nullable = false)
    String inputDataFormat;

    @Column(columnDefinition = "text", nullable = false)
    String outputDataFormat;


    @Enumerated(EnumType.STRING)
    Category category;

    @OneToMany(mappedBy = "task")
    List<Test> tests;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "author_id")
    User author;
}
