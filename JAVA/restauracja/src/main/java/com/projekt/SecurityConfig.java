package com.projekt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        http.authorizeRequests()
                .antMatchers("/h2").permitAll()
                .antMatchers("/**").authenticated()
                .and()
                .logout().logoutUrl("/logout").logoutSuccessUrl("/index.xhtml")
                .and()
                .csrf().disable();

        http.headers().frameOptions().disable();

    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.inMemoryAuthentication().withUser("kelner")
                .password("{noop}kelner").roles("WAITER")
                .and()
                .withUser("admin").password("{noop}admin").roles("ADMIN");
    }
}
