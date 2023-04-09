package ru.rsreu.pukin.springlabs.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.util.matcher.AntPathRequestMatcher

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Profile("dev")
class SecurityConfiguration(
    val userDetailsService: UserDetailsService
): WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity?) {
        http!!.csrf().disable()
            .authorizeRequests()
            .antMatchers("/auth/registration").permitAll()
            .anyRequest()
            .authenticated()
            .and()
            .formLogin()
            .loginPage("/auth/login").permitAll()
            .defaultSuccessUrl("/index")
            .and()
            .logout()
            .logoutRequestMatcher(AntPathRequestMatcher("/auth/logout", "POST"))
            .invalidateHttpSession(true)
            .clearAuthentication(true)
            .deleteCookies("JSESSIONID")
            .logoutSuccessUrl("/auth/login")
    }

    override fun configure(auth: AuthenticationManagerBuilder?) {
        auth!!.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    protected fun passwordEncoder(): PasswordEncoder? {
        return BCryptPasswordEncoder(12)
    }

    @Bean
    protected fun daoAuthenticationProvider(): DaoAuthenticationProvider? {
        val daoAuthenticationProvider = DaoAuthenticationProvider()
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder())
        daoAuthenticationProvider.setUserDetailsService(userDetailsService)
        return daoAuthenticationProvider
    }
}