package com.laioffer.onlineOrder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Configuration
    @Order(2)
    public static class CustomerConfigAdapter extends WebSecurityConfigurerAdapter {
        public CustomerConfigAdapter() {
            super();
        }

        @Autowired
        private DataSource dataSource;

        @Override
        protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
            auth
                    .jdbcAuthentication()
                    .dataSource(dataSource)
                    .usersByUsernameQuery("select email, password, enabled from customers where email = ?")
                    .authoritiesByUsernameQuery("select email, authorities from authorities where email = ?");
            // authentication manager (see below)

        }
        protected void configure(HttpSecurity http) throws Exception {
            http
                    //.antMatcher("/order/**")
                    //.antMatcher("/cart")
                    //.antMatcher("/checkout")
                    //.antMatcher("/login")
                    .authorizeRequests()
                    .antMatchers("/order/*", "/cart", "/checkout").hasAuthority("ROLE_USER")
                    .anyRequest()
                    .permitAll()
                    //.hasRole("USER")

                    .and()
                    .formLogin()
                    //.loginPage("/loginUser")
                    .loginProcessingUrl("/login")
                    .failureUrl("/login?error=true")
                    /*
                    .loginPage("/loginUser")
                    .loginProcessingUrl("/user_login")

                    .defaultSuccessUrl("/userPage")

                    .and()
                    .logout()
                    .logoutUrl("/user_logout")
                    .logoutSuccessUrl("/protectedLinks")
                    .deleteCookies("JSESSIONID")

                    .and()
                    .exceptionHandling()
                    .accessDeniedPage("/403")
                    */
                    .and()
                    .csrf().disable();
                    http.cors();
        }

        @Bean
        public static NoOpPasswordEncoder passwordEncoder() {
            return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
        }
    }

    @Configuration
    @Order(1)
    public static class ManagerConfigAdapter extends WebSecurityConfigurerAdapter {
        public ManagerConfigAdapter() {
            super();
        }

        @Autowired
        private DataSource dataSource;

        @Override
        protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
            auth
                    .jdbcAuthentication()
                    .dataSource(dataSource)
                    .usersByUsernameQuery("select email, password, enabled from business where email = ?")
                    .authoritiesByUsernameQuery("select email, authorities from authorities where email = ?");
            // authentication manager (see below)

        }
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .antMatcher("/business/**")
                    .authorizeRequests()
                    //.antMatchers("/admin/*").hasAuthority("ROLE_ADMIN")
                    .anyRequest()
                   // .permitAll()
                    .hasRole("BUSINESS")

                    .and()
                    .formLogin()
                    //.loginPage("/loginAdmin")
                    .loginProcessingUrl("/business/login")
                    .failureUrl("/business/login?error=true")
                    /*
                    .loginPage("/loginUser")
                    .loginProcessingUrl("/user_login")

                    .defaultSuccessUrl("/userPage")

                    .and()
                    .logout()
                    .logoutUrl("/user_logout")
                    .logoutSuccessUrl("/protectedLinks")
                    .deleteCookies("JSESSIONID")

                    .and()
                    .exceptionHandling()
                    .accessDeniedPage("/403")
                    */
                    .and()
                    .csrf().disable();
            http.cors();
        }

        @Bean
        public static NoOpPasswordEncoder passwordEncoder() {
            return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
        }
    }

    /*
    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth
                .jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("select email, password, enabled from customers where email = ?")
                .authoritiesByUsernameQuery("select email, authorities from authorities where email = ?");
        // authentication manager (see below)

    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {

        http.csrf().disable()
                .formLogin()
                .failureForwardUrl("/login?error=true");
        http
                .authorizeRequests()
                .antMatchers("/order/*", "/cart", "/checkout").hasAuthority("ROLE_USER")
                .anyRequest().permitAll();

        // http builder configurations for authorize requests and form login (see below)
    }

    @SuppressWarnings("deprecation")
    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }
*/
}
