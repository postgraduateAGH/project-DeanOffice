package pl.edu.agh.ki.mwo.SchoolWebApp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pl.edu.agh.ki.mwo.SchoolWebApp.entity.Grades;
import pl.edu.agh.ki.mwo.SchoolWebApp.entity.Student;
import pl.edu.agh.ki.mwo.SchoolWebApp.entity.Subjects;
import pl.edu.agh.ki.mwo.SchoolWebApp.repository.GradesRepository;
import pl.edu.agh.ki.mwo.SchoolWebApp.repository.StudentRepository;
import pl.edu.agh.ki.mwo.SchoolWebApp.repository.SubjectRepository;

@Controller
public class GradesController {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private GradesRepository gradeRepository;
    @Autowired
    private SubjectRepository subjectRepository;

    @RequestMapping(value = "/Grades")
    public String gradeList(Model model) {

        model.addAttribute("gradesList", gradeRepository.findAll());
        return "gradeList";
    }
    @RequestMapping(value = "/AddGrade")
    public String displayAddSchoolClassForm(Model model, HttpSession session) {
        model.addAttribute("gradesList", gradeRepository.findAll());
        model.addAttribute("students", studentRepository.findAll());
        model.addAttribute("subjects", subjectRepository.findAll());
        return "gradeForm";
    }

    @RequestMapping(value = "/DeleteGrade", method = RequestMethod.POST)
    public String deletegrade(@RequestParam(value = "gradeId", required = false) String gradeId,
            Model model) {

        gradeRepository.deleteById(Long.valueOf(gradeId));
        model.addAttribute("gradesList", gradeRepository.findAll());

        return "gradeList";
    }

    @RequestMapping(value = "/CreateGrade", method = RequestMethod.POST)
    public String createSchoolClass
            (@RequestParam(value = "gradeName", required = false) String gradeName,
                    @RequestParam(value = "studentId", required = false) String studentId,
                    @RequestParam(value = "subjectId", required = false) String subjectId,
                    Model model) {
        Grades grades = new Grades();
        grades.setGrade(Double.valueOf(gradeName));
        Student student = studentRepository.findById(Long.valueOf(studentId)).get();
        Subjects subjects = subjectRepository.findById(Long.valueOf(subjectId)).get();
        grades.setStudent(student);
        grades.setSubjects(subjects);

        gradeRepository.save(grades);
        model.addAttribute("gradesList", gradeRepository.findAll());

        return "gradeList";
    }

    @RequestMapping(value = "/ShowUpdateGradeForm")
    public String showUpdategradeForm(@RequestParam(value = "gradeId") String gradeId, Model model,
            HttpSession session) {

        Grades grades = gradeRepository.findById(Long.valueOf(gradeId)).get();
        model.addAttribute("grades", grades);
        model.addAttribute("grade", gradeRepository.findAll());
        model.addAttribute("students", studentRepository.findAll());
        model.addAttribute("subjects", subjectRepository.findAll());


        return "gradeUpdateForm";
    }

    @RequestMapping(value = "/UpdateGrade", method = RequestMethod.POST)
    public String updategrade(
            @RequestParam(value = "gradeId") String gradeId,
            @RequestParam(value = "gradeName", required = false) String gradeName,
            @RequestParam(value = "studentId", required = false) String studentId,
            @RequestParam(value = "subjectId", required = false) String subjectId, Model model, HttpSession session) {

        Grades grades = gradeRepository.findById(Long.valueOf(gradeId)).get();
        grades.setGrade(Double.valueOf(gradeName));
        Student student = studentRepository.findById(Long.valueOf(studentId)).get();
        Subjects subjects = subjectRepository.findById(Long.valueOf(subjectId)).get();
        grades.setStudent(student);
        grades.setSubjects(subjects);

        // update
        gradeRepository.save(grades);
        model.addAttribute("gradesList", gradeRepository.findAll());

        return "gradeList";
    }



}
