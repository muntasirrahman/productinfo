package com.pensil.lab.productinfo;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder builder) throws Exception {
        builder.inMemoryAuthentication()
                .withUser("user").password("{noop}user1234").roles("USER")
                .and()
                .withUser("admin").password("{noop}admin1234").roles("USER", "ADMIN");
    }

    @Override
    protected void configure(HttpSecurity security) throws Exception {
        security.httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/api/products").hasRole("USER")
                .antMatchers(HttpMethod.POST, "/api/products/**").hasRole("USER")
                .antMatchers(HttpMethod.PUT, "/api/products").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/api/products/**").hasRole("ADMIN")
                .and()
                .csrf().disable()
                .formLogin().disable();

        // to allow h2 web console
        security.headers().frameOptions().disable();
    }
}