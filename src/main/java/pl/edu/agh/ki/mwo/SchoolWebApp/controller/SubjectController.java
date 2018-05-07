package pl.edu.agh.ki.mwo.SchoolWebApp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pl.edu.agh.ki.mwo.SchoolWebApp.entity.School;
import pl.edu.agh.ki.mwo.SchoolWebApp.entity.SchoolClass;
import pl.edu.agh.ki.mwo.SchoolWebApp.entity.Subjects;
import pl.edu.agh.ki.mwo.SchoolWebApp.entity.Teacher;
import pl.edu.agh.ki.mwo.SchoolWebApp.repository.SchoolClassRepository;
import pl.edu.agh.ki.mwo.SchoolWebApp.repository.SchoolRepository;
import pl.edu.agh.ki.mwo.SchoolWebApp.repository.SubjectRepository;
import pl.edu.agh.ki.mwo.SchoolWebApp.repository.TeacherRepository;


@Controller
public class SubjectController {

	@Autowired
	private TeacherRepository teacherRepository;
	@Autowired
	private SubjectRepository subjectRepository;

	@RequestMapping(value = "/Subjects")
	public String subjectList(Model model) {

		model.addAttribute("subjectsList", subjectRepository.findAll());
		return "subjectList";
	}

	@RequestMapping(value = "/AddSubject")
	public String displayAddSchoolClassForm(Model model, HttpSession session) {
		model.addAttribute("subjectsList", subjectRepository.findAll());
		model.addAttribute("teachers", teacherRepository.findAll());
		return "SubjectForm";
	}

	@RequestMapping(value = "/DeleteSubject", method = RequestMethod.POST)
	public String deleteSubject(@RequestParam(value = "subjectId", required = false) String subjectId,
			Model model) {

		subjectRepository.deleteById(Long.valueOf(subjectId));
		model.addAttribute("subjectsList", subjectRepository.findAll());

		return "subjectList";
	}

	@RequestMapping(value = "/CreateSubject", method = RequestMethod.POST)
	public String createSchoolClass
			(@RequestParam(value = "subjectName", required = false) String subjectName,
			@RequestParam(value = "teacher", required = false) String teacherId,
			Model model) {
		Subjects subjects = new Subjects();
		subjects.setName(subjectName);
		Teacher teacher = teacherRepository.findById(Long.valueOf(teacherId)).get();
		subjects.setTeacher(teacher);

		subjectRepository.save(subjects);
		model.addAttribute("subjectsList", subjectRepository.findAll());

		return "subjectList";
	}

	@RequestMapping(value = "/ShowUpdateSubjectForm")
	public String showUpdateSubjectForm(@RequestParam(value = "subjectId") String subjectId, Model model,
			HttpSession session) {

		Subjects subjects = subjectRepository.findById(Long.valueOf(subjectId)).get();
		model.addAttribute("subjects", subjects);
		model.addAttribute("subject", subjectRepository.findAll());
		model.addAttribute("teachers", teacherRepository.findAll());

		return "subjectUpdateForm";
	}

	@RequestMapping(value = "/UpdateSubject", method = RequestMethod.POST)
	public String updateSubject(
			@RequestParam(value = "subjectId") String subjectId,
			@RequestParam(value = "subjectName", required = false) String subjectName,
			@RequestParam(value = "teacher", required = false) String teacherId
			, Model model, HttpSession session) {


		Teacher teacher = teacherRepository.findById(Long.valueOf(teacherId)).get();
		Subjects subjects = subjectRepository.findById(Long.valueOf(subjectId)).get();
		subjects.setTeacher(teacher);
		subjects.setName(subjectName);

		// update
		subjectRepository.save(subjects);
		model.addAttribute("subjectsList", subjectRepository.findAll());

		return "subjectList";
	}



}