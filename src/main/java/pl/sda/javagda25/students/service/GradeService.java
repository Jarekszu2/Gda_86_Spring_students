package pl.sda.javagda25.students.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sda.javagda25.students.model.Grade;
import pl.sda.javagda25.students.model.Student;
import pl.sda.javagda25.students.repository.GradeRepository;
import pl.sda.javagda25.students.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class GradeService {
    private final GradeRepository gradeRepository;
    private final StudentRepository studentRepository;

    public List<Grade> getAllGrades() {
        return gradeRepository.findAll();
    }

    public void add(Grade grade) {
        gradeRepository.save(grade);
    }

    public void deleteById(Long gradeId) {
        gradeRepository.deleteById(gradeId);
    }

    public Optional<Grade> finfById(Long grId) {
        return gradeRepository.findById(grId);
    }


    public void save(Grade grade, Long studentParam) {
        // get one zawsze zwraca studenta a nie optional.
        // używamy tylko gdy mamy pewność że obiekt jest w bazie
        Student student = studentRepository.getOne(studentParam);
        grade.setStudent(student);

        gradeRepository.save(grade);
    }
}
