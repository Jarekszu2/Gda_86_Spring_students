package pl.sda.javagda25.students.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.sda.javagda25.students.model.Grade;
import pl.sda.javagda25.students.model.GradeSubject;
import pl.sda.javagda25.students.model.Student;
import pl.sda.javagda25.students.service.GradeService;

import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
@RequestMapping(path = "/grade/")
public class GradeController {
    private final GradeService gradeService;

    @GetMapping("/glist")
    public String list(Model model) {
        List<Grade> grades = gradeService.getAllGrades();

        model.addAttribute("gradeList", grades);

        return "grade-list";
    }

    @GetMapping("/add/{studentId}")
    public String add(Model model, Grade grade, @PathVariable(name = "studentId") Long studentId) {
        model.addAttribute("graade", grade);
        model.addAttribute("subjects", GradeSubject.values());
        model.addAttribute("studentId", studentId);

        return "grade-add";
    }

    @PostMapping("/add")
    public String add(Grade grade, Long studentParam) {
        gradeService.save(grade, studentParam);

        return "redirect:/grade/glist";
    }

    @GetMapping("/delete/{deleted_grade_id}")
    public String deleteByPathVariable(@PathVariable(name = "deleted_grade_id") Long gradeId) {
        gradeService.deleteById(gradeId);
        return "redirect:/grade/glist";
    }

    @GetMapping("/delete")
    public String deleteByRequestParam(@RequestParam(name = "gId") Long graId) {
        gradeService.deleteById(graId);
        return "redirect:/grade/glist";
    }

    @GetMapping("/edit/{edited_grade_id}")
    public String editByPathVariable(Model model,
                                     @PathVariable(name = "edited_grade_id") Long grId) {
        Optional<Grade> optionalGrade = gradeService.finfById(grId);
        if (optionalGrade.isPresent()) {
            model.addAttribute("graade", optionalGrade.get());
            model.addAttribute("subjects", GradeSubject.values());
            model.addAttribute("studentId", optionalGrade.get().getStudent().getId());

            return "grade-add";
        }
        return "redirect:/grade/glist";
    }

    @GetMapping("/edit")
    public String editByRequestParam(Model model,
                                     @RequestParam(name = "edited_gId") Long grade_RP_id) {
        Optional<Grade> optionalGrade = gradeService.finfById(grade_RP_id);
        if (optionalGrade.isPresent()) {
            model.addAttribute("graade", optionalGrade.get());
            model.addAttribute("subjects", GradeSubject.values());
            model.addAttribute("studentId", optionalGrade.get().getStudent().getId());

            return "grade-add";
        }
        return "redirect:/grade/glist";
    }
}
