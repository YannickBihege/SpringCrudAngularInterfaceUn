        package com.bihege.springAngular.crudfirst.com.bihege.springAngular.crudfirst.api.config;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.context.annotation.Bean;
        import org.springframework.context.annotation.ComponentScan;
        import org.springframework.context.annotation.Configuration;
        import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
        import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
        import org.springframework.security.config.annotation.web.builders.HttpSecurity;
        import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
        import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
        import org.springframework.security.core.userdetails.UserDetailsService;
        import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


        @ComponentScan
        @Configuration
        @EnableWebSecurity
        @EnableGlobalMethodSecurity(prePostEnabled = true)
        public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {

            @Autowired
            private UserDetailsService userDetailsService;

            @Bean
            public BCryptPasswordEncoder encodePWD(){
                return new BCryptPasswordEncoder();
            }
            @Override
            protected void configure(HttpSecurity http) throws  Exception{
                http.cors();
                http.csrf().disable();
                http.authorizeRequests() .antMatchers("/rest/**")
                        .authenticated().anyRequest().permitAll()
                        .and().formLogin().permitAll();
                /*
                http.authorizeRequests() .antMatchers("/**")
                        .fullyAuthenticated()
                        .and().httpBasic();
                        */
            }

            /*
            @Override
            protected void configure(AuthenticationManagerBuilder auth) throws Exception{
                auth.inMemoryAuthentication()
                        .withUser("user").
                        password("{noop}password")
                        .roles("USER");
            }
            */

            @Override
            protected void configure(AuthenticationManagerBuilder auth) throws Exception{
            auth.userDetailsService(userDetailsService)
                    .passwordEncoder(encodePWD());

            }

        }