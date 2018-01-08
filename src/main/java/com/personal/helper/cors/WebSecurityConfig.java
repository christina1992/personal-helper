package com.personal.helper.cors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;

/*
    Created by hnastevska on 3/20/2017.
*/
@Configuration
@EnableWebSecurity
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//    @Autowired
//    private UserDetailsService userDetailsService;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    protected void configure(HttpSecurity http) throws Exception {
        http
                .addFilterBefore(new SimpleCORSFilter(), ChannelProcessingFilter.class)
                .authorizeRequests()
                .antMatchers("/*")
                .permitAll()
//                .and()
//                .authorizeRequests()
//                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll().and()
//                .authorizeRequests()
//                .antMatchers("/screen/**").permitAll().and()
//                .authorizeRequests()
//                .antMatchers("/*/widgets/*/data").permitAll().and()
//                .authorizeRequests()
//                .anyRequest()
//                .authenticated()
                .and()
                .csrf().disable();

    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("admin").password("admin").roles();
        //auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }


}
