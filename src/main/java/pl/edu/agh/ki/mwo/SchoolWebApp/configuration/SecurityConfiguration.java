package pl.edu.agh.ki.mwo.SchoolWebApp.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private DataSource dataSource;
	
	@Value("${spring.queries.users-query}")
	private String usersQuery;
	
	@Value("${spring.queries.roles-query}")
	private String rolesQuery;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.
			jdbcAuthentication()
				.usersByUsernameQuery(usersQuery)
				.authoritiesByUsernameQuery(rolesQuery)
				.dataSource(dataSource)
				.passwordEncoder(bCryptPasswordEncoder);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.
			authorizeRequests()
				.antMatchers("/").permitAll()
				.antMatchers("/login").permitAll()
				.antMatchers("/welcome").permitAll()
				.antMatchers("/Students").permitAll()
				.antMatchers("/registration").hasAuthority("ADMIN")
				.antMatchers("/registration").hasAuthority("ADMIN")

				// grades for admin and lecturer only
				.antMatchers("/Grades").hasAnyAuthority("ADMIN","LECTURER")
				.antMatchers("/AddGrade").hasAnyAuthority("ADMIN","LECTURER")
				.antMatchers("/DeleteGrade").hasAnyAuthority("ADMIN","LECTURER")
				.antMatchers("/CreateGrade").hasAnyAuthority("ADMIN","LECTURER")
				.antMatchers("/ShowUpdateGradeForm").hasAnyAuthority("ADMIN","LECTURER")
				.antMatchers("/UpdateGrade").hasAnyAuthority("ADMIN","LECTURER")

				// presences for admin and lecturer only
				.antMatchers("/Presences").hasAnyAuthority("ADMIN","LECTURER")
				.antMatchers("/AddPresence").hasAnyAuthority("ADMIN","LECTURER")
				.antMatchers("/DeletePresence").hasAnyAuthority("ADMIN","LECTURER")
				.antMatchers("/CreatePresence").hasAnyAuthority("ADMIN","LECTURER")
				.antMatchers("/ShowUpdatePresenceForm").hasAnyAuthority("ADMIN","LECTURER")
				.antMatchers("/UpdatePresence").hasAnyAuthority("ADMIN","LECTURER")

				// only for admin Schools, SchoolClasses, Students, Subject and Teacher
				.antMatchers("/SchoolClasses").hasAuthority("ADMIN")
				.antMatchers("/AddSchoolClass").hasAuthority("ADMIN")
				.antMatchers("/CreateSchoolClass").hasAuthority("ADMIN")
				.antMatchers("/DeleteSchoolClass").hasAuthority("ADMIN")
				.antMatchers("/ShowUpdateSchoolClassForm").hasAuthority("ADMIN")
				.antMatchers("/UpdateSchoolClass").hasAuthority("ADMIN")

				.antMatchers("/Schools").hasAuthority("ADMIN")
				.antMatchers("/AddSchool").hasAuthority("ADMIN")
				.antMatchers("/CreateSchool").hasAuthority("ADMIN")
				.antMatchers("/DeleteSchool").hasAuthority("ADMIN")
				.antMatchers("/ShowUpdateSchoolForm").hasAuthority("ADMIN")
				.antMatchers("/UpdateSchool").hasAuthority("ADMIN")

				.antMatchers("/Students").hasAuthority("ADMIN")
				.antMatchers("/DeleteStudent").hasAuthority("ADMIN")
				.antMatchers("/AddStudent").hasAuthority("ADMIN")
				.antMatchers("/CreateStudent").hasAuthority("ADMIN")
				.antMatchers("/ShowUpdateStudentForm").hasAuthority("ADMIN")
				.antMatchers("/UpdateStudent").hasAuthority("ADMIN")

				.antMatchers("/Subjects").hasAuthority("ADMIN")
				.antMatchers("/AddSubject").hasAuthority("ADMIN")
				.antMatchers("/DeleteSubject").hasAuthority("ADMIN")
				.antMatchers("/CreateSubject").hasAuthority("ADMIN")
				.antMatchers("/ShowUpdateSubjectForm").hasAuthority("ADMIN")
				.antMatchers("/UpdateSubject").hasAuthority("ADMIN")

				.antMatchers("/Teachers").hasAuthority("ADMIN")
				.antMatchers("/DeleteTeacher").hasAuthority("ADMIN")
				.antMatchers("/AddTeacher").hasAuthority("ADMIN")
				.antMatchers("/CreateTeacher").hasAuthority("ADMIN")
				.antMatchers("/ShowUpdateTeacherForm").hasAuthority("ADMIN")
				.antMatchers("/UpdateTeacher").hasAuthority("ADMIN")

				// student view
				.antMatchers("/studentView").hasAuthority("STUDENT")
				
				.anyRequest()
				.authenticated().and().csrf().disable().formLogin()
				.loginPage("/login").failureUrl("/login?error=true")
				.defaultSuccessUrl("/welcome")
				.usernameParameter("email")
				.passwordParameter("password")
				.and().logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/login").and().exceptionHandling()
				.accessDeniedPage("/access-denied");
		// antMatchers("matcher") . hasRole("role") albo hasAnyRole("lista"), ** wszystkie subdirectories
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
	    web
	       .ignoring()
	       .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
	}

}