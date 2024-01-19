package ru.danilspirin.backend.repository;

import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import ru.danilspirin.backend.model.Tournament;
import ru.danilspirin.backend.model.records.Category;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TournamentSpecifications {

    public static Specification<Tournament> findByCategory(Optional<Category> category) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            category.ifPresent(value -> predicates.add(criteriaBuilder.equal(root.get("category"), value.name())));

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
