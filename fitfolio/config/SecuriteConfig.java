package com.example.fitfolio.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecuriteConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeRequests(authorize -> authorize
                        .antMatchers("/api/v1/utilisateur/saveleila").permitAll()
                        .antMatchers("/api/v1/utilisateur/addPlanRepas").permitAll()
                        .antMatchers("/api/v1/utilisateur/fetchRepas").permitAll()
                        .antMatchers("/api/v1/utilisateur/fetchRepajour").permitAll()
                        .antMatchers("/api/v1/utilisateur/addPlanActivite").permitAll()
                        .antMatchers("/api/v1/utilisateur/fetchActivite").permitAll()
                        .antMatchers("/api/v1/utilisateur/fetchActivitejour").permitAll()
                        .antMatchers("/api/v1/utilisateur/addDate").permitAll()
                        .antMatchers("/api/v1/utilisateur/dateE").permitAll()
                        .antMatchers("/api/v1/utilisateur/edit").permitAll()
                        .antMatchers("/api/v1/utilisateur/cherche").permitAll()
                        .antMatchers("/api/v1/utilisateur/cherche1").permitAll()
                        .antMatchers("/api/v1/utilisateur/fetchActivitejour").permitAll()
                        .antMatchers("/api/v1/utilisateur/deleteRepas").permitAll()
                        .antMatchers("/api/v1/utilisateur/deleteActivite").permitAll()
                        .anyRequest().authenticated());           
    }
}
