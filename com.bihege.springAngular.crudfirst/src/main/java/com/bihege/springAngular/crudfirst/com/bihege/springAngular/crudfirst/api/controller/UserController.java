package com.bihege.springAngular.crudfirst.com.bihege.springAngular.crudfirst.api.controller;


import com.bihege.springAngular.crudfirst.com.bihege.springAngular.crudfirst.api.dao.UserRepository;
import com.bihege.springAngular.crudfirst.com.bihege.springAngular.crudfirst.api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@CrossOrigin(origins = "*" )
public class UserController {

    @Autowired
    private UserRepository repository;

    @PostMapping("/register")
    public User register(@RequestBody User user){

        System.out.print("Registration attempted");
        return repository.save(user);
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

    @GetMapping("/")
    public String login(){
        return "authenticated successfully" ;
    }



}
