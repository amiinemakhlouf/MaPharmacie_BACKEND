package com.proxym.myPharmacy.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.annotation.Order
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain


@Configuration
@EnableWebSecurity
class SecurityConfig  {

    @Bean
    fun filterChain(httpSecurity: HttpSecurity) :SecurityFilterChain
    {
         httpSecurity.csrf().disable().authorizeHttpRequests()
            .requestMatchers("/api/register").permitAll()
             .requestMatchers("/api/login").permitAll()
            .anyRequest().authenticated()
            .and()
            .httpBasic()
        httpSecurity.csrf().disable();
        httpSecurity.headers().frameOptions().disable();


        return httpSecurity.build()


    }
}
