package pl.edu.agh.ki.mwo.SchoolWebApp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pl.edu.agh.ki.mwo.SchoolWebApp.entity.SchoolClass;
import pl.edu.agh.ki.mwo.SchoolWebApp.entity.Student;
import pl.edu.agh.ki.mwo.SchoolWebApp.repository.GradesRepository;
import pl.edu.agh.ki.mwo.SchoolWebApp.repository.PresenceRepository;
import pl.edu.agh.ki.mwo.SchoolWebApp.repository.SchoolClassRepository;
import pl.edu.agh.ki.mwo.SchoolWebApp.repository.StudentRepository;

@Controller
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SchoolClassRepository schoolClassRepository;

    @Autowired
    private GradesRepository gradeRepository;
    
	@Autowired
	private PresenceRepository presenceRepository;
    
    @RequestMapping(value = "/Students")
    public String listStudents(Model model, HttpSession session) {

        model.addAttribute("students", studentRepository.findAll());
        return "studentsList";
    }
    
    @RequestMapping(value = "/StudentView")
    public String studentView(Model model, HttpSession session) {
    	// zalogowany user
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	String currentPrincipalName = authentication.getName();
    	// sql z where dla danego usera tylko
    	
    	// do modelu dodamy oceny i obecnosci
    	model.addAttribute("gradesList", gradeRepository.findAll());
    	model.addAttribute("presencesList", presenceRepository.findAll());
        return "studentView";
    }

    @RequestMapping(value = "/DeleteStudent", method = RequestMethod.POST)
    public String deleteStudent(@RequestParam(value = "studentId", required = false) String studentId, Model model, HttpSession session) {

        studentRepository.deleteById(Long.valueOf(studentId));

        model.addAttribute("students", studentRepository.findAll());
        model.addAttribute("message", "Student zostal dodany");

        return "studentsList";
    }

    @RequestMapping(value = "/AddStudent")
    public String displayAddStudentForm(Model model, HttpSession session) {

        model.addAttribute("classes", schoolClassRepository.findAll());
        return "studentForm";
    }

    @RequestMapping(value = "/CreateStudent", method = RequestMethod.POST)
    public String createStudent(@RequestParam(value = "studentName", required = false) String studentName,
            @RequestParam(value = "studentSurname", required = false) String studentSurname,
            @RequestParam(value = "studentPesel", required = false) String studentPesel,
            @RequestParam(value = "studentClass", required = false) String studentClass, Model model, HttpSession session) {

        Student student = new Student();
        student.setName(studentName);
        student.setSurname(studentSurname);
        student.setPesel(studentPesel);
        SchoolClass schoolClass = schoolClassRepository.findById(Long.valueOf(studentClass)).get();
        student.setSchoolClass(schoolClass);

        studentRepository.save(student);

        model.addAttribute("students", studentRepository.findAll());
        model.addAttribute("message", "Student zostal dodany");

        return "studentsList";
    }

    @RequestMapping(value = "/ShowUpdateStudentForm")
    public String showUpdateStudentForm(@RequestParam(value = "studentId") Long studentId, Model model, HttpSession session) {

        Student student = studentRepository.findById(studentId).get();
        model.addAttribute("student", student);
        if (schoolClassRepository.findAll() != null) {
            model.addAttribute("schoolClasses", schoolClassRepository.findAll());
        }

        return "studentUpdateForm";
    }

    @RequestMapping(value = "/UpdateStudent", method = RequestMethod.POST)
    public String updateSchoolClass(@RequestParam(value = "studentName", required = false) String studentName,
            @RequestParam(value = "studentSurname", required = false) String studentSurname, @RequestParam(value = "studentPesel") String studentPesel,
            @RequestParam(value = "studentId") Long studentId, @RequestParam(value = "studentClass") Long studentClass, Model model, HttpSession session) {

        Student student = studentRepository.findById(studentId).get();
        student.setName(studentName);
        student.setSurname(studentName);
        student.setPesel(studentPesel);

        SchoolClass schoolClass = schoolClassRepository.findById(studentClass).get();

        student.setSchoolClass(schoolClass);

        // update
        studentRepository.save(student);

        model.addAttribute("students", studentRepository.findAll());
        model.addAttribute("message", "Student zostal dodany");

        return "studentsList";
    }
}
