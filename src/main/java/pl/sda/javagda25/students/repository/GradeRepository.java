package pl.sda.javagda25.students.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.javagda25.students.model.Grade;

public interface GradeRepository extends JpaRepository<Grade, Long> {
}
