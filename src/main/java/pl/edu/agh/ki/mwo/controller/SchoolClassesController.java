package pl.edu.agh.ki.mwo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pl.edu.agh.ki.mwo.entity.School;
import pl.edu.agh.ki.mwo.entity.SchoolClass;
import pl.edu.agh.ki.mwo.repository.SchoolClassRepository;
import pl.edu.agh.ki.mwo.repository.SchoolRepository;

@Controller
public class SchoolClassesController {

    @Autowired
    private SchoolRepository schoolRepository;

    @Autowired
    private SchoolClassRepository schoolClassRepository;

    @RequestMapping(value = "/SchoolClasses")
    public String listSchoolClass(Model model, HttpSession session) {
        if (session.getAttribute("userLogin") == null)
            return "redirect:/Login";
        model.addAttribute("schoolClasses", schoolClassRepository.findAll());

        return "schoolClassesList";
    }

    @RequestMapping(value = "/AddSchoolClass")
    public String displayAddSchoolClassForm(Model model, HttpSession session) {
        if (session.getAttribute("userLogin") == null)
            return "redirect:/Login";

        model.addAttribute("schools", schoolRepository.findAll());

        return "schoolClassForm";
    }

    @RequestMapping(value = "/CreateSchoolClass", method = RequestMethod.POST)
    public String createSchoolClass(@RequestParam(value = "schoolClassStartYear", required = false) String startYear,
            @RequestParam(value = "schoolClassCurrentYear", required = false) String currentYear,
            @RequestParam(value = "schoolClassProfile", required = false) String profile,
            @RequestParam(value = "schoolClassSchool", required = false) String schoolId, Model model, HttpSession session) {
        if (session.getAttribute("userLogin") == null)
            return "redirect:/Login";

        SchoolClass schoolClass = new SchoolClass();
        schoolClass.setStartYear(Integer.valueOf(startYear));
        schoolClass.setCurrentYear(Integer.valueOf(currentYear));
        schoolClass.setProfile(profile);
        School school = schoolRepository.findById(Long.valueOf(schoolId)).get();
        schoolClass.setSchool(school);

        schoolClassRepository.save(schoolClass);
        model.addAttribute("schoolClasses", schoolClassRepository.findAll());
        model.addAttribute("message", "Nowa klasa została dodana");

        return "schoolClassesList";
    }

    @RequestMapping(value = "/DeleteSchoolClass", method = RequestMethod.POST)
    public String deleteSchoolClass(@RequestParam(value = "schoolClassId", required = false) String schoolClassId, Model model, HttpSession session) {
        if (session.getAttribute("userLogin") == null)
            return "redirect:/Login";

        schoolClassRepository.deleteById(Long.valueOf(schoolClassId));
        model.addAttribute("schoolClasses", schoolClassRepository.findAll());
        model.addAttribute("message", "Klasa została usunięta");

        return "schoolClassesList";
    }

    @RequestMapping(value = "/ShowUpdateSchoolClassForm")
    public String showUpdateSchoolClassForm(@RequestParam(value = "schoolClassId") String schoolClassId, Model model, HttpSession session) {
        if (session.getAttribute("userLogin") == null)
            return "redirect:/Login";

        SchoolClass schoolClass = schoolClassRepository.findById(Long.valueOf(schoolClassId)).get();
        model.addAttribute("schoolClass", schoolClass);
        model.addAttribute("schools", schoolRepository.findAll());

        return "schoolClassUpdateForm";
    }

    @RequestMapping(value = "/UpdateSchoolClass", method = RequestMethod.POST)
    public String updateSchoolClass(@RequestParam(value = "schoolClassStartYear", required = false) String schoolClassStartYear,
            @RequestParam(value = "schoolClassCurrentYear", required = false) String schoolClassCurrentYear,
            @RequestParam(value = "schoolClassProfile") String schoolClassProfile, @RequestParam(value = "schoolClassId") String schoolClassId,
            @RequestParam(value = "schoolClassSchool") String schoolClassSchool, Model model, HttpSession session) {

        if (session.getAttribute("userLogin") == null)
            return "redirect:/Login";

        SchoolClass schoolClass = schoolClassRepository.findById(Long.valueOf(schoolClassId)).get();
        schoolClass.setStartYear(Integer.valueOf(schoolClassStartYear));
        schoolClass.setCurrentYear(Integer.valueOf(schoolClassCurrentYear));
        schoolClass.setProfile(schoolClassProfile);

        School school = schoolRepository.findById(Long.valueOf(schoolClassSchool)).get();

        schoolClass.setSchool(school);
        // update
        schoolClassRepository.save(schoolClass);
        model.addAttribute("schoolClasses", schoolClassRepository.findAll());
        model.addAttribute("message", "Klasa zaktualizowana");

        return "schoolClassesList";
    }

}