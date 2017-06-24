package net.chandol.study.config;

import net.chandol.study.security.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserService userService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //@formatter:off
        http
            .authorizeRequests()
                .anyRequest()
                    .permitAll()
                .and()
            .formLogin()
                .loginProcessingUrl("/login")
                .permitAll()
                .and()
            .logout()
                .logoutUrl("/logout")
                .permitAll()
                .and()
            .userDetailsService(userService)
            .csrf()
                .disable();
        //@formatter:on
    }

}
