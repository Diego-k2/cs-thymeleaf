package br.com.thymleaf.curso.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
@EnableWebSecurity
public class WebSecurityConfig {


    public  SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity
                .httpBasic()
                .and()
                .authorizeHttpRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin( form -> form
                        .loginPage("/login")
                        .successForwardUrl("/") //pagina padrão
                        .permitAll())
                .logout(logout -> logout.logoutUrl("/logout"))
                .csrf().disable();
                return httpSecurity.build();
    }


//    public void newUser(){
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        UserDetails userDetails = User.builder()
//                .username("maria")
//                .password(passwordEncoder.encode("123"))
//                .roles("ADMIN")
//                .build();
//    }
//
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
