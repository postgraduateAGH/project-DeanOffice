package pl.edu.agh.ki.mwo.SchoolWebApp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pl.edu.agh.ki.mwo.SchoolWebApp.entity.SchoolClass;
import pl.edu.agh.ki.mwo.SchoolWebApp.entity.Student;
import pl.edu.agh.ki.mwo.SchoolWebApp.entity.Teacher;
import pl.edu.agh.ki.mwo.SchoolWebApp.repository.SchoolClassRepository;
import pl.edu.agh.ki.mwo.SchoolWebApp.repository.TeacherRepository;

@Controller
public class TeacherController {

	@Autowired
	private TeacherRepository teacherRepository;

	@Autowired
	private SchoolClassRepository schoolClassRepository;

	@RequestMapping(value = "/Teachers")
	public String listTeachers(Model model, HttpSession session) {

		model.addAttribute("teachers", teacherRepository.findAll());
		return "teachersList";
	}

	@RequestMapping(value = "/DeleteTeacher", method = RequestMethod.POST)
	public String deleteTeacher(@RequestParam(value = "teacherId", required = false) String teacherId, Model model,
			HttpSession session) {

		teacherRepository.deleteById(Long.valueOf(teacherId));

		model.addAttribute("teachers", teacherRepository.findAll());
		model.addAttribute("message", "Nauczyciel zostal dodany");

		return "teachersList";
	}

	/*
	 * @RequestMapping(value = "/AddStudent") public String
	 * displayAddStudentForm(Model model, HttpSession session) {
	 * 
	 * model.addAttribute("classes", schoolClassRepository.findAll()); return
	 * "studentForm"; }
	 * 
	 * @RequestMapping(value = "/CreateStudent", method = RequestMethod.POST) public
	 * String createStudent(@RequestParam(value = "studentName", required = false)
	 * String studentName,
	 * 
	 * @RequestParam(value = "studentSurname", required = false) String
	 * studentSurname,
	 * 
	 * @RequestParam(value = "studentPesel", required = false) String studentPesel,
	 * 
	 * @RequestParam(value = "studentClass", required = false) String studentClass,
	 * Model model, HttpSession session) {
	 * 
	 * Student student = new Student(); student.setName(studentName);
	 * student.setSurname(studentSurname); student.setPesel(studentPesel);
	 * SchoolClass schoolClass =
	 * schoolClassRepository.findById(Long.valueOf(studentClass)).get();
	 * student.setSchoolClass(schoolClass);
	 * 
	 * teacherRepository.save(student);
	 * 
	 * model.addAttribute("students", teacherRepository.findAll());
	 * model.addAttribute("message", "Student zostal dodany");
	 * 
	 * return "studentsList"; }
	 */
	@RequestMapping(value = "/ShowUpdateTeacherForm")
	public String showUpdateStudentForm(@RequestParam(value = "teacherId") Long teacherId, Model model,
			HttpSession session) {

		Teacher student = teacherRepository.findById(teacherId).get();
		model.addAttribute("teacher", student);
		return "teacherUpdateForm";
	}

	@RequestMapping(value = "/UpdateTeacher", method = RequestMethod.POST)
	public String updateTeacher(@RequestParam(value = "teacherName", required = false) String teacherName,
			@RequestParam(value = "teacherSurname", required = false) String teacherSurname,
			@RequestParam(value = "teacherTitle", required = false) String teacherTitle,
			@RequestParam(value = "teacherPesel") String teacherPesel,
			@RequestParam(value = "teacherId") Long teacherId, Model model, HttpSession session) {

		Teacher teacher = teacherRepository.findById(teacherId).get();
		teacher.setName(teacherName);
		teacher.setSurname(teacherSurname);
		teacher.setTitle(teacherTitle);
		teacher.setPesel(teacherPesel);

		// update
		teacherRepository.save(teacher);

		model.addAttribute("teachers", teacherRepository.findAll());
		model.addAttribute("message", "Dane nauczyciela zostaly zmienione");

		return "teachersList";
	}
}
