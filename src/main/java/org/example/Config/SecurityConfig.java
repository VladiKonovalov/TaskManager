package org.example.Config;

import org.example.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers("/tasks").authenticated()
//                .antMatchers("/").authenticated()
//                .antMatchers("/signup_form", "/users/register").permitAll()
//                .antMatchers("/h2-console/**").permitAll()
//                .anyRequest().permitAll()
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .defaultSuccessUrl("/tasks")
//                .permitAll()
//                .and()
//                .logout()
//                .logoutSuccessUrl("/login")
//                .permitAll();

        http
                .authorizeRequests()
                .antMatchers("/tasks").authenticated()
                .antMatchers( "/signup_form", "/users/register").permitAll()
                .antMatchers("/h2-console/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/tasks", true)
                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/login")
                .permitAll();
        // Allow frames for H2 console
        http
                .headers()
                .frameOptions().sameOrigin();

        // Disable CSRF for the H2 console
        http
                .csrf().disable();
    }
    @Override
    public void configure(WebSecurity web) throws Exception {
        // Allow H2 console to be accessed without authentication
        web
                .ignoring()
                .antMatchers("/h2-console/**");
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService((UserDetailsService) userService);
    }

      @Bean
    public PasswordEncoder passwordEncoder() {
        // NoOpPasswordEncoder is not secure, use it only for demonstration or testing purposes
        return NoOpPasswordEncoder.getInstance();
    }
}
