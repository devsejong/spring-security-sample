package net.chandol.study;

import net.chandol.study.security.User;
import net.chandol.study.security.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import static java.util.Collections.singletonList;
import static org.springframework.boot.SpringApplication.run;

@SpringBootApplication
public class Application {

	@Autowired
	UserRepository repository;

	@PostConstruct
	@Transactional
	public void initUser(){
		repository.save(new User("admin", "admin", singletonList("ADMIN")));
		repository.save(new User("user", "user", singletonList("USER")));
	}

	public static void main(String[] args) {
		run(Application.class, args);
	}
}
