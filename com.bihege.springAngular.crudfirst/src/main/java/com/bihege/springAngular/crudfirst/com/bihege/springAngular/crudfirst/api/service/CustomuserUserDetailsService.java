package com.bihege.springAngular.crudfirst.com.bihege.springAngular.crudfirst.api.service;

import com.bihege.springAngular.crudfirst.com.bihege.springAngular.crudfirst.api.dao.UserRepository;
import com.bihege.springAngular.crudfirst.com.bihege.springAngular.crudfirst.api.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomuserUserDetailsService implements UserDetailsService {

    private UserRepository repository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByUsername(username);

        CustomerUserDetails userDetails = null;
        if(user != null){
            userDetails = new CustomerUserDetails();
            userDetails.setUser(user);
        }else{
            throw new UsernameNotFoundException("User does not exist");
        }
        return null;
    }
}
