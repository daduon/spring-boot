package com.example.donation.controller;

import java.util.concurrent.ExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.donation.entity.User;
import com.example.donation.playload.request.UserRequest;
import com.example.donation.playload.response.UserResponse;
import com.example.donation.repository.UserRepository;
import com.example.donation.service.CustomUserDetailsService;
import com.example.donation.util.JwtUtil;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired 
    CustomUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @Autowired
    private UserRepository userRepository;

    @Autowired
	private PasswordEncoder bcryptEncoder;

    @GetMapping("/")
    public String home(){
        return "Hello home";
    }

    @GetMapping("/test")
    public String test(){
        return "Test";
    }
    @GetMapping("/user")
    public String user(){
        return "Hello user";
    }

    @GetMapping("/admin")
    public String admin(){
        return "Hello admin";
    }

    @PostMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody UserRequest userRequest) throws ExecutionException{
        try {
            authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userRequest.getUsername(), userRequest.getPassword())
            );

        }catch (BadCredentialsException e) {
            throw new ExecutionException("Incorrect username or password", e);
        }
        
        final UserDetails userDetails = userDetailsService
            .loadUserByUsername(userRequest.getUsername());

        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new UserResponse(token,userDetails.getUsername(),userDetails.getPassword()));
    }

    @PostMapping("/register")
	public ResponseEntity<?> saveUser(@RequestBody UserRequest userRequest) throws Exception {
        User user = new User();
        user.setUsername(userRequest.getUsername());
        user.setPassword(bcryptEncoder.encode(userRequest.getPassword()));
        user.setActive(true);
        user.setRoles("ROLE_USER");
        user.setCreatedAt(new java.util.Date(System.currentTimeMillis()));
		return ResponseEntity.ok(userRepository.save(user));
	}
}
