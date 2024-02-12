package com.example.security.controller;

import com.example.security.service.AuthenticationUserDetailService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final AuthenticationUserDetailService authenticationUserDetailService;

    public AuthenticationController(AuthenticationManager authenticationManager, AuthenticationUserDetailService authenticationUserDetailService) {
        this.authenticationManager = authenticationManager;
        this.authenticationUserDetailService = authenticationUserDetailService;
    }

    @PostMapping("/authenticate")
    public String authentication(@RequestBody UserAuthenRequest request) {
        // verify username, password from request
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.username(), request.password()));
        // if verified can trust username then generate jwt token
        return authenticationUserDetailService.generateJwt(request.username());
    }
}

record UserAuthenRequest(String username, String password){}
