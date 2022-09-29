package com.bihege.springAngular.crudfirst.com.bihege.springAngular.crudfirst.api.controller;

import com.bihege.springAngular.crudfirst.com.bihege.springAngular.crudfirst.api.dao.UserRepository;
import com.bihege.springAngular.crudfirst.com.bihege.springAngular.crudfirst.api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/secure/rest")
@CrossOrigin(origins = "*" )
public class AdminController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

   @PostMapping("/admin/add")
    public String addUserByAdmin(@RequestBody User user){
       String password = user.getPassword();
       String encryptPwd = passwordEncoder.encode(password);
       user.setPassword(encryptPwd);
       userRepository.save(user);
        return "User added successfully";
    }
}
