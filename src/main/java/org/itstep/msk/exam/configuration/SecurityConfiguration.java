package org.itstep.msk.exam.configuration;

import org.itstep.msk.exam.service.PlainPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;

    @Autowired
    private PlainPasswordEncoder passwordEncoder;

    @Override
    public void configure(WebSecurity webSecurity) throws Exception {
        webSecurity.ignoring()
                .antMatchers("/css/**")
                .antMatchers("/images/**")
                .antMatchers("/js/**");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        final String usersByUsernameQuery = "SELECT username, password, 1 as active FROM users WHERE username = ?";
        final String authoritiesByUsernameQuery = "SELECT u.username, r.role "
                + "FROM users u "
                + "INNER JOIN user_roles ur ON ur.user_id = u.id "
                + "INNER JOIN roles r ON r.id = ur.role_id "
                + "WHERE u.username = ?";

        authenticationManagerBuilder.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery(usersByUsernameQuery)
                .authoritiesByUsernameQuery(authoritiesByUsernameQuery)
                .passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/issues/**").hasRole("DEVELOPER")
                .antMatchers("/").hasAnyRole("DEVELOPER", "USER")
                .anyRequest().authenticated();

        httpSecurity.csrf().disable();

        httpSecurity.formLogin()
                .loginPage("/login")
                .failureUrl("/login?error=true")
                .defaultSuccessUrl("/")
                .usernameParameter("username")
                .passwordParameter("password");

        httpSecurity.logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/");

        httpSecurity.exceptionHandling()
                .accessDeniedPage("/denied");
    }
}
