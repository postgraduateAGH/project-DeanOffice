package pl.edu.agh.ki.mwo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import pl.edu.agh.ki.mwo.entity.Grade;
import pl.edu.agh.ki.mwo.entity.Student;
import pl.edu.agh.ki.mwo.repository.GradeRepository;
import pl.edu.agh.ki.mwo.repository.StudentRepository;

@SpringBootApplication
public class SchoolWebAppApplication  {

	public static void main(String[] args) {
		SpringApplication.run(SchoolWebAppApplication.class, args);
	}

	@Autowired
	GradeRepository gradeRepository;

	@Autowired
	StudentRepository studentRepository;


	/*@Override
	public void run(String... args) throws Exception {

		Student student = new Student();
		student.setName("Testowy33");
		student.setSurname("Student33");

		Grade ocena = new Grade();
		ocena.setGrade(5.0);

		ocena.setStudent(student);

		System.out.println("TEST");
		System.out.println(ocena.getStudent().getName());
		gradeRepository.save(ocena);
		studentRepository.save(student);


	}*/

}
