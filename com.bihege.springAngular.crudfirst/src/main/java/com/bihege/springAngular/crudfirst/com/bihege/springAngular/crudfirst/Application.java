package com.bihege.springAngular.crudfirst.com.bihege.springAngular.crudfirst;

import com.bihege.springAngular.crudfirst.com.bihege.springAngular.crudfirst.api.dao.UserRepository;
import com.bihege.springAngular.crudfirst.com.bihege.springAngular.crudfirst.api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class Application {


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
