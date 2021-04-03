//package com.middlend.middlend.config;
//
////import org.springframework.context.annotation.Configuration;
////import org.springframework.http.HttpMethod;
////import org.springframework.security.config.annotation.web.builders.HttpSecurity;
////import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
////@Configuration
////public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
////    @Override
////    public void configure(HttpSecurity http) throws Exception {
////        http.csrf().disable().authorizeRequests()
////                .antMatchers("/").permitAll()
////                .antMatchers(HttpMethod.POST,"/newuser").permitAll()
////                .antMatchers(HttpMethod.POST, "/login").permitAll()
////                .antMatchers(HttpMethod.POST,"/newuser/*").permitAll()
////                .antMatchers(HttpMethod.GET,"/master/*").permitAll()
////                .antMatchers(HttpMethod.GET,"/exploreCourse").permitAll()
////                .anyRequest().authenticated();
////
////    }
////}
//
////
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.boot.autoconfigure.security.SecurityProperties;
////import org.springframework.context.annotation.Bean;
////import org.springframework.context.annotation.Configuration;
////import org.springframework.core.annotation.Order;
////import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
////import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
////import org.springframework.security.config.annotation.web.builders.HttpSecurity;
////import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
////import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
////import org.springframework.security.core.userdetails.UserDetailsService;
////import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
////import org.springframework.security.crypto.password.PasswordEncoder;
////import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
////import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
////import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
////
////import javax.sql.DataSource;
////
////@Configuration
////@EnableWebSecurity
////@EnableGlobalMethodSecurity(prePostEnabled = true)
////@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
////public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
////    @Autowired
////    UserDetailsService userDetailsService;
////
////    @Autowired
////    UserService userService;
////
////    @Autowired
////    private DataSource datasource;
////
////    @Override
////    protected void configure(HttpSecurity http) throws Exception {
////         http.authorizeRequests().antMatchers("/bus/topologie", "/home")
////         http.authorizeRequests().anyRequest().authenticated()
////         .antMatchers("/admin/**").access("hasRole('ADMIN')").and()
////         .formLogin().failureUrl("/login?error")
////         .defaultSuccessUrl("/bus/topologie").loginPage("/login")
////         .permitAll().and().logout()
////         .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
////         .logoutSuccessUrl("/login").permitAll().and().rememberMe()
////         .rememberMeParameter("remember-me")
////         .tokenRepository(persistentTokenRepository())
////         .tokenValiditySeconds(86400).and().csrf();
////    }
////
////    @Bean
////    public PersistentTokenRepository persistentTokenRepository() {
////        JdbcTokenRepositoryImpl tokenRepositoryImpl = new JdbcTokenRepositoryImpl();
////        tokenRepositoryImpl.setDataSource(datasource);
////        return tokenRepositoryImpl;
////    }
////
////    @Override
////    protected void configure(AuthenticationManagerBuilder auth)
////            throws Exception {
////
////        PasswordEncoder encoder = new BCryptPasswordEncoder();
////
////        auth.userDetailsService(userDetailsService).passwordEncoder(encoder);
////        auth.jdbcAuthentication().dataSource(datasource);
////
////        if (!userService.userExists("user")) {
////            User userAdmin = new User("user", encoder.encode("password"), true);
////            Set<Authorities> authorities = new HashSet<Authorities>();
////            authorities.add(new Authorities(userAdmin,"ADMIN"));
////            authorities.add(new Authorities(userAdmin,"CRIP"));
////            authorities.add(new Authorities(userAdmin,"USER"));
////            userAdmin.setAuthorities(authorities);
////
////            userService.createUser(userAdmin);
////        }
////    }
////
////}
//
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        //...
//    }
//
//    @Override
//    protected void configure(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity.authorizeRequests().antMatchers("/").permitAll();
//    }
//}
//
