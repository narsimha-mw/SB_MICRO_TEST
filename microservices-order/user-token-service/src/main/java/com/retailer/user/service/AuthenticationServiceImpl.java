package com.retailer.user.service;

import com.retailer.user.config.JwtService;
import com.retailer.user.dto.AuthenticationRequest;
import com.retailer.user.model.MyAppUser;
import com.retailer.user.model.Role;
import com.retailer.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import com.retailer.user.dto.AuthenticationMyUserRequest;
import com.retailer.user.dto.AuthenticationMyUserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private final PasswordEncoder passwordEncoder;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Override
    public AuthenticationMyUserResponse register(AuthenticationMyUserRequest request) {
        try {
            MyAppUser myAppUser1 = MyAppUser.builder()
                    .userName(request.getUserName())
                    .userEmail(request.getUserEmail())
                    .userPassword(passwordEncoder.encode(request.getUserPassword()))
//                    .userPassword(request.getUserPassword())
                    .role(Role.USER)
                    .build();
            userRepository.save(myAppUser1);
            String responseToken = jwtService.getToken(myAppUser1);
            return AuthenticationMyUserResponse.builder()
                    .userName(myAppUser1.getUsername())
                    .userEmail(myAppUser1.getUserEmail())
                    .token(responseToken)
                    .build();
        }catch (BadCredentialsException e){
            return AuthenticationMyUserResponse.builder()
                    .message("Invalid credentials").build();
        }
    }
    @Override
    public AuthenticationMyUserResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUserEmail(),
                        request.getUserPassword())
        );
        MyAppUser user = userRepository.findByUserEmail(request.getUserEmail()).orElseThrow();
        String responseToken = jwtService.getToken(user);
        return AuthenticationMyUserResponse.builder()
                .token(responseToken)
                .build();
    }
}