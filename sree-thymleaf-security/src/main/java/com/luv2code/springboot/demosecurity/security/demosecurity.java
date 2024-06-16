package com.luv2code.springboot.demosecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class demosecurity {
    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails john = User.builder()
                .username("john")
                .password("{noop}john123")
                .roles("SELLER")
                .build();

        UserDetails susan = User.builder()
                .username("susan")
                .password("{noop}susan123")
                .roles("BUYER")
                .build();

        UserDetails sree = User.builder()
                .username("sree")
                .password("{noop}sree123")
                .roles("BUYER", "SELLER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(john, susan, sree);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configure -> configure
                .requestMatchers("/").hasAnyRole("ADMIN", "BUYER", "SELLER")
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .requestMatchers("/sellers/**").hasRole("SELLER")
                .requestMatchers("/buyer/**").hasRole("BUYER")
                .anyRequest().authenticated()
        )
        .formLogin(form -> form
                .loginPage("/showMyLoginPage")
                .loginProcessingUrl("/authenticateTheUser")
                .permitAll()
        )
        .logout(logout -> logout.permitAll())
        .exceptionHandling(configure -> 
                configure.accessDeniedPage("/access-denied"));

        return http.build();
    }
}
