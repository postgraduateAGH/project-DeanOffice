package pl.edu.agh.mwo2017.group2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {
	// glowny view
	@RequestMapping("/")
	String showMainView() {
		return "main";
	}

	// view do logowania view zmapowany do main page
	@RequestMapping("/login")
	String showLoginView() {
		return "login";
	}

	@RequestMapping("/lecturer")
	String showLecturerView() {
		return "lecturer";
	}

	@RequestMapping("/administrator")
	String showAdministratorView() {
		return "administrator";
	}

	@RequestMapping("/student")
	String showStudentView() {
		return "student";
	}

	@RequestMapping("grades")
	String showStudentGrades() {
		return "grades";
	}

}
