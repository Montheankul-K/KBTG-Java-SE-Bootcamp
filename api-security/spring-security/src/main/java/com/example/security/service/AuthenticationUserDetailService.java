package com.example.security.service;

import com.example.security.repository.UserRepository;
import com.example.security.securityconfig.CustomUserDetail;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;
    private final JwtService jwtService;

    public AuthenticationUserDetailService(UserRepository userRepository, JwtService jwtService) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findUserByUsername(username);
    }

    public String generateJwt(String username) {
        CustomUserDetail userDetail = userRepository.findUserByUsername(username);
        return jwtService.generateToken(userDetail);
    }
}

/*
    // user details service
    @Bean
    public UserDetailsService userDetailsService() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        // UserDetails user = User.withUsername("member")
        // hash password assume hash password in database
        // .password(encoder.encode("password"))
        // set role if request hash password match with hash password
        // .roles("MEMBER") // ROLE_MEMBER
        // grant permission
        // .authorities("MEMBER_READ", "MEMBER_UPDATE")
        // .build();

        UserDetails admin = User.withUsername("admin")
                .password(encoder.encode("password"))
                .roles("ADMIN")
                .build();

        // custom user detail
        CustomUserDetail user = new CustomUserDetail("member", encoder.encode("password"));
        user.setRoles(List.of("MEMBER"));
        user.setPermissions(List.of("MEMBER_READ"));

        // use only in development purpose
        return new InMemoryUserDetailsManager(user, admin);
    }
*/
