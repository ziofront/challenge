package com.ziofront.challenge.security;

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
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // super.configure(auth);
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        // super.configure(web);
        web.ignoring().antMatchers("/resources/**");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // super.configure(http);
        http.httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers("/api/**").hasRole("BASIC")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login") // default
                .loginProcessingUrl("/authenticate")
                .failureUrl("/login?error") // default
                .defaultSuccessUrl("/home")
                .usernameParameter("email")
                .passwordParameter("password")
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout") // default
                .logoutSuccessUrl("/login")
                .permitAll()
                /*
                    로컬 H2 설정
                 */
                .and()
                .authorizeRequests()
                .antMatchers("/h2-console/*")
                .anonymous()
                .anyRequest()
                .permitAll()
                .and()
                .headers().frameOptions().sameOrigin()
                .and()
                .csrf().ignoringAntMatchers("/h2-console/**").disable()
        ;

    }
}
