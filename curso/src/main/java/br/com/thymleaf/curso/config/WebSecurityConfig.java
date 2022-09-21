package br.com.thymleaf.curso.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig{

        @Bean
        public  SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
            httpSecurity
                    .authorizeHttpRequests()
                        .antMatchers("/").permitAll()
                        .anyRequest().authenticated()
                    .and()
                    .formLogin(form -> form
                            .loginPage("/login")
                            .defaultSuccessUrl("/usuario", true)
                            .permitAll())
                    .logout(logout -> logout.logoutUrl("/logout"))
                    .csrf().disable();
                    return httpSecurity.build();
    }


    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


}
