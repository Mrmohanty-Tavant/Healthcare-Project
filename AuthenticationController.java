package com.datastack.thehealthcare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.datastack.thehealthcare.config.AuthenticationService;
import com.datastack.thehealthcare.model.AuthenticationRequest;
import com.datastack.thehealthcare.model.AuthenticationResponse;
import com.datastack.thehealthcare.util.JwtUtil;

@RestController
@RequestMapping("/login")
public class AuthenticationController {

	@Autowired
	private AuthenticationService authenticationService;

	@Autowired
	private JwtUtil jwtTokenUtil;
	
	
	@PostMapping(value = "/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

		try {
			Authentication authentication =  authenticationService.authenticateUser(authenticationRequest.getUsername(),authenticationRequest.getPassword());

	        if (authentication != null && authentication.isAuthenticated()) {
	            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
	            AuthenticationResponse jwtToken = jwtTokenUtil.generateToken(userDetails);
	            return ResponseEntity.ok(jwtToken);
	        } else {
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentication failed!");
	        }
		}
		catch (BadCredentialsException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentication failed!");
		}

	}

}

