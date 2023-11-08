package com.web.usersmanagement.controller;

import com.web.usersmanagement.dto.AuthRequest;
import com.web.usersmanagement.model.User;
import com.web.usersmanagement.model.UserInfo;
import com.web.usersmanagement.serviceImpl.AuthService;
import com.web.usersmanagement.serviceImpl.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class AuthController {

    @Autowired
    public AuthService authService;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/new/auth")
    public String addNewUserAuth(@RequestBody UserInfo userInfo){
        return authService.addUser(userInfo);
    }
    @GetMapping("/users/auth")
    List<UserInfo> getAllUsersAuth(){
        return authService.getAllUsersInfo();
    }

////////////////////////////////
    @PostMapping("/authenticate")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(authRequest.getUsername());
        } else {
            throw new UsernameNotFoundException("invalid user request !");
        }


    }

}
