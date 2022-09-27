package com.bihege.springAngular.crudfirst.com.bihege.springAngular.crudfirst.api.controller;


import com.bihege.springAngular.crudfirst.com.bihege.springAngular.crudfirst.api.dao.UserRepository;
import com.bihege.springAngular.crudfirst.com.bihege.springAngular.crudfirst.api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@CrossOrigin(origins = "*" )
public class UserController {

    @Autowired
    private UserRepository repository;

    /*
    @PostMapping("/register")
    public String registerOld(@RequestBody User user){
        repository.save(user);
        return "Hello "+ user.getName() + "Your registration process successfully completed";
    }
    */

    @PostMapping("/register")
    public User register(@RequestBody User user){
        return repository.save(user);
       // console.log ("Hello "+ user.getName() + "Your registration process successfully completed");
    }


    @GetMapping("/getAllUsers")
    public List<User> findAllUsers(){
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

    //--------------------------------
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


	/*
	// Overtaken Spring Security
	@GetMapping("/getUsers")
	public List<User> getUsers(){
		return Stream.of(new User(11,"Guy","specialguy@gmail.com",4,"Engineer Hardware"),
				new User(12,"Santosh","santosh@gmail.com",8, "ProjectManager"),
						new User(13,"Basant","basant@gmail.com",12,"Engineer Electronics")).
				collect(Collectors.toList());
	}
	*/
}
