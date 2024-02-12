package com.example.security.securityconfig;

import com.example.security.service.AuthenticationUserDetailService;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.stereotype.Component;

import static org.springframework.security.config.Customizer.withDefaults;

@Component
@EnableWebSecurity // handle security config
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

    private final AuthenticationUserDetailService authenticationUserDetailService;
    private final JwtAuthFilter jwtAuthFilter;

    public SecurityConfig(AuthenticationUserDetailService authenticationUserDetailService, JwtAuthFilter jwtAuthFilter) {
        this.authenticationUserDetailService = authenticationUserDetailService;
        this.jwtAuthFilter = jwtAuthFilter;
    }

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        // disable CSRF token
        // http.csrf(httpSecurityCsrfConfigurer -> httpSecurityCsrfConfigurer.disable()); or
        http.csrf(AbstractHttpConfigurer::disable);
        http.authorizeHttpRequests((requests) -> requests
                // all request need to authentication except /api/public/**
                .requestMatchers("/api/public/**").permitAll()
                .requestMatchers(HttpMethod.POST, "/api/auth/authenticate").permitAll()
                // request that access GET /api/member/** need permission MEMBER_READ
                // .requestMatchers(HttpMethod.GET, "/api/member").hasAuthority("MEMBER_READ")
                // .requestMatchers(HttpMethod.PUT, "/api/member").hasAuthority("MEMBER_UPDATE")
                // implement role base
                // .requestMatchers("/api/member/**").hasAnyRole("MEMBER","ADMIN")
                .requestMatchers("/api/admin/**").hasAnyRole("ADMIN")
                .anyRequest().authenticated());
        http.formLogin(withDefaults());
        // use api key filter before basic authentication filter
        http.addFilterBefore(
                // new ApiKeyAuthFilter
                // use jwt authentication filter
                jwtAuthFilter , BasicAuthenticationFilter.class);
        // basic authentication filter
        http.httpBasic(withDefaults());
        return http.build();
    }

    // set authentication manager to use own provider
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfiguration) throws Exception {
        return authConfiguration.getAuthenticationManager();
    }

    // hash request password
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // create own provider
    @Bean
    public AuthenticationProvider authenticationProvider() {
        // use type DaoAuthenticationProvider to create provider
        final DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(authenticationUserDetailService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }
}
