//package com.example.onlinetest.config;
//
//
//import com.example.onlinetest.security.JwtFilter;
//import com.example.onlinetest.service.AuthService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.web.context.WebApplicationContext;
//
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    @Autowired
//    AuthService authService;
//
//    @Autowired
//    JwtFilter jwtFilter;
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
////        http
////                .cors().and().csrf().disable()
////                .sessionManagement()
////                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
////                .and()
////                .authorizeRequests()
////                .antMatchers("/auth/**").permitAll()
////                .antMatchers("/api/**")
////                .authenticated();
////
////        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(authService);
//    }
//
//    @Override
//    protected AuthenticationManager authenticationManager() throws Exception {
//        return super.authenticationManager();
//    }
//
//    @Bean
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }
//}
