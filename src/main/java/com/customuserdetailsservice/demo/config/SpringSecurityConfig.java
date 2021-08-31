package com.customuserdetailsservice.demo.config;

import com.customuserdetailsservice.demo.filter.JwtRequestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public CustomUserDetailsService customUserDetailsService;
    //private DataSource dataSource;

    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService);
       // auth.jdbcAuthentication().dataSource(dataSource)
         //       .usersByUsernameQuery("SELECT username, password, enabled FROM my_users WHERE username=?")
           //     .authoritiesByUsernameQuery("SELECT username, authority FROM my_authorities AS a WHERE username=?");
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http

                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/users/**").hasRole("USER")
                .antMatchers(HttpMethod.GET,"/admin/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/teacher/**").hasRole("TEACHER")
                .antMatchers(HttpMethod.GET,"/agenda/**").hasRole("USER")
                .antMatchers(HttpMethod.GET,"/coins/**").hasRole("USER")
                .antMatchers(HttpMethod.GET,"/lesson/**").authenticated()
                .antMatchers(HttpMethod.GET,"/review/**").hasRole("USER")
                .antMatchers(HttpMethod.GET,"/review/**").hasRole("TEACHER")
                .antMatchers("/authenticated").authenticated()
                .antMatchers("/authenticate").permitAll()
                .anyRequest().permitAll()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }


}
