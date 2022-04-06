package pl.sda.javagda25.students.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.javagda25.students.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
