package com.bihege.springAngular.crudfirst.com.bihege.springAngular.crudfirst;

import com.bihege.springAngular.crudfirst.com.bihege.springAngular.crudfirst.api.dao.UserRepository;
import com.bihege.springAngular.crudfirst.com.bihege.springAngular.crudfirst.api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
@RestController
@CrossOrigin(origins = "*" )
public class Application {
	@Autowired
	private UserRepository repository;

	@PostMapping("/register")
	public String register(@RequestBody User user){
		repository.save(user);
		return "Hello "+ user.getName() + "Your registration process successfully completed";
	}

	@GetMapping("/getAllUsers")
	public List <User> findAllUsers(){
		return repository.findAll();
	}

 	@GetMapping("/findUser/{email}")
	public List <User> findUser(@PathVariable String email){
		return repository.findByEmail(email);
	}

	@DeleteMapping("/cancel/{id}")
	public List<User> cancelRegistration(@PathVariable int id){
		repository.deleteById(id);
		return repository.findAll();
	}

	@GetMapping("/")
	public String login(){
		return "authenticated successfully" ;
	}

	// Overtaken Spring Security
	@GetMapping("/getUsers")
	public List<User> getUsers(){
		return Stream.of(new User(11,"Guy","specialguy@gmail.com",4,"Engineer Hardware"),
				new User(12,"Santosh","santosh@gmail.com",8, "ProjectManager"),
						new User(13,"Basant","basant@gmail.com",12,"Engineer Electronics")).
				collect(Collectors.toList());
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
