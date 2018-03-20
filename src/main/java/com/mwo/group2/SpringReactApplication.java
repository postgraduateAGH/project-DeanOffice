package com.mwo.group2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.mwo.group2.domain.Student;
import com.mwo.group2.domain.StudentRepository;

@SpringBootApplication
@ComponentScan()
public class SpringReactApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringReactApplication.class, args);
	}
	
	
	@Component
	public class DatabaseLoader implements CommandLineRunner {
	 
	    private final StudentRepository repository;
	 
	    @Autowired
	    public DatabaseLoader(StudentRepository repository) {
	        this.repository = repository;
	    }
	 
	    @Override
	    public void run(String... strings) throws Exception {
	        this.repository.save(new Student("John", "Johnson", "john@john.com"));
	        this.repository.save(new Student("Mary", "Poppins", "pop@mary.com"));
	        this.repository.save(new Student("Rob", "Robber", "rob@bery.com"));
	        this.repository.save(new Student("Kate", "Robinson", "kate@robinson.com"));
	    }
	}	
}
