package com.datastack.thehealthcare.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.datastack.thehealthcare.serviceImpl.MyUserDetailsServiceImpl;

@Service
public class AuthenticationService {

	@Autowired
     MyUserDetailsServiceImpl userDetailsService;

    public AuthenticationService(MyUserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    public Authentication authenticateUser(String username, String password) {
        // Load user details from the userDetailsService based on the provided username
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);

        // Perform authentication (e.g., check if the provided password matches the user's password)
        if (userDetails != null && userDetails.getPassword().equals(password)) {
            return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        } else {
            return null; // Authentication failed
        }
    }
}
