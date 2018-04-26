package pl.edu.agh.ki.mwo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.edu.agh.ki.mwo.repository.GradeRepository;
import pl.edu.agh.ki.mwo.repository.StudentRepository;

@Controller
public class GradeController {

    @Autowired
    GradeRepository gradeRepository;


    //@Autowired
    //SchoolGradeRepository schoolGradeRepository;


    @Autowired
    private StudentRepository studentRepository;
    @RequestMapping(value = "/Grades", method = RequestMethod.GET)
    public String listGrades(Model model, HttpSession session) {
        if (session.getAttribute("userLogin") == null)
            return "redirect:/Login";


       // model.addAttribute("gradeList",schoolGradeRepository.findAll() );
        model.addAttribute("grades",gradeRepository.findAll() );
        return "gradesList";
    }

}
