package com.cg.sp_hbn_product.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class BasicConfiguration {

    @Bean
    public InMemoryUserDetailsManager userDetailsService(PasswordEncoder passwordEncoder) {
        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority("ADMIN");
        UserDetails user = User.withUsername("user")
                .password(passwordEncoder.encode("123123"))
                .roles("USER")
                .build();

        UserDetails admin = User.withUsername("admin")
                .password(passwordEncoder.encode("123123"))
                .roles("USER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        return encoder;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        /*

        localhost:8080/js/app.js
        localhost:8080/css/style.css


        database: role: ROLE_USER, ROLE_ADMIN  || SAI: USER, ADMIN

        Article: CREATE_ARTICLE, EDIT_ARTICLE, DELETE_ARTICLE
        Product: CREATE_PRODUCT, EDIT_PRODUCT, DELETE_PRODUCT
         */
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/assets/**").permitAll()
                        .requestMatchers("/products/edit").hasRole("USER")
                        .requestMatchers("/products/edit").hasAuthority("USER")
                        .requestMatchers("/", "/customers/add", "/mylogin").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin((form) -> form
                        .loginPage("/login")                // GET
                        .loginProcessingUrl("/mylogin")     // POST
                        .defaultSuccessUrl("/products", true)
                        .failureUrl("/fail")
                        .permitAll()
                )
                .logout((logout) -> logout.permitAll())
//                .csrf().disable(); // Disable CSRF protection
        ;

        return http.build();
    }

//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails user =
//                User.withDefaultPasswordEncoder()
//                        .username("user")
//                        .password("password")
//                        .roles("USER")
//                        .build();
//
//        return new InMemoryUserDetailsManager(user);
//    }
}