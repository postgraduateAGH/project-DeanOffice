package pl.edu.agh.ki.mwo.SchoolWebApp.controller;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pl.edu.agh.ki.mwo.SchoolWebApp.entity.Presence;
import pl.edu.agh.ki.mwo.SchoolWebApp.entity.SchoolClass;
import pl.edu.agh.ki.mwo.SchoolWebApp.entity.Student;
import pl.edu.agh.ki.mwo.SchoolWebApp.entity.Subjects;
import pl.edu.agh.ki.mwo.SchoolWebApp.entity.Teacher;
import pl.edu.agh.ki.mwo.SchoolWebApp.repository.PresenceRepository;
import pl.edu.agh.ki.mwo.SchoolWebApp.repository.SchoolClassRepository;
import pl.edu.agh.ki.mwo.SchoolWebApp.repository.StudentRepository;
import pl.edu.agh.ki.mwo.SchoolWebApp.repository.SubjectRepository;
import pl.edu.agh.ki.mwo.SchoolWebApp.repository.TeacherRepository;

@Controller
public class PresenceController {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private SubjectRepository subjectRepository;

	@Autowired
	private PresenceRepository presenceRepository;

	@RequestMapping(value = "/Presences")
	public String subjectList(Model model) {

		model.addAttribute("presencesList", presenceRepository.findAll());
		return "presencesList";
	}

	@RequestMapping(value = "/AddPresence")
	public String displayAddSchoolClassForm(Model model, HttpSession session) {
		model.addAttribute("subjectsList", subjectRepository.findAll());
		model.addAttribute("studentsList", studentRepository.findAll());
		return "presenceForm";
	}

	@RequestMapping(value = "/DeletePresence", method = RequestMethod.POST)
	public String deletePresence(@RequestParam(value = "presenceId", required = false) String presenceId, Model model) {

		presenceRepository.deleteById(Long.valueOf(presenceId));
		model.addAttribute("presencesList", presenceRepository.findAll());

		return "presencesList";
	}

	@RequestMapping(value = "/CreatePresence", method = RequestMethod.POST)
	public String createPresence(@RequestParam(value = "presence", required = false) String presence,
		@RequestParam(value = "studentId", required = false) String studentId,
		@RequestParam(value = "date", required = false) String date,
		@RequestParam(value = "subjectId", required = false) String subjectId, Model model) {
		Presence new_presence=new Presence();

		Student student = studentRepository.findById(Long.valueOf(studentId)).get();
		Subjects subject = subjectRepository.findById(Long.valueOf(subjectId)).get();
		new_presence.setStudent(student);
		new_presence.setSubject(subject);
		new_presence.setPresence(Integer.valueOf(presence));

		java.sql.Date date_for_sql = java.sql.Date.valueOf(date);
		new_presence.setDateField(date);
		
		presenceRepository.save(new_presence);
		model.addAttribute("presencesList", presenceRepository.findAll());

		return "presencesList";
	}

	@RequestMapping(value = "/ShowUpdatePresenceForm")
	public String showUpdatePresenceForm(@RequestParam(value = "presenceId") String presenceId, Model model,
			HttpSession session) {

		Presence presence = presenceRepository.findById(Long.valueOf(presenceId)).get();
		model.addAttribute("presence", presence);
		model.addAttribute("subjects", subjectRepository.findAll());
		model.addAttribute("students", studentRepository.findAll());

		return "presenceUpdateForm";
	}

	@RequestMapping(value = "/UpdatePresence", method = RequestMethod.POST)
	public String updateSubject(@RequestParam(value = "studentId") String studentId,
			@RequestParam(value = "subjectId", required = false) String subjectId,
			@RequestParam(value = "presenceId", required = false) String presenceId,
			@RequestParam(value = "presence", required = false) String presence,
			@RequestParam(value = "date", required = false) String date, Model model, HttpSession session) {

		Presence existing_presence = presenceRepository.findById(Long.valueOf(presenceId)).get();

		Student student = studentRepository.findById(Long.valueOf(studentId)).get();
		Subjects subject = subjectRepository.findById(Long.valueOf(subjectId)).get();
		existing_presence.setStudent(student);
		existing_presence.setSubject(subject);
		existing_presence.setPresence(Integer.valueOf(presence));

		java.sql.Date date_for_sql = java.sql.Date.valueOf(date);
		existing_presence.setDateField(date);

		// update
		presenceRepository.save(existing_presence);
		model.addAttribute("presencesList", presenceRepository.findAll());

		return "presencesList";
	}
}