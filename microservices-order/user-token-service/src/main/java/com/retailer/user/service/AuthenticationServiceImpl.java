package com.retailer.user.service;

import com.retailer.user.config.JwtService;
import com.retailer.user.dto.AuthenticationRequest;
import com.retailer.user.model.MyAppUser;
import com.retailer.user.model.Role;
import com.retailer.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.retailer.user.dto.AuthenticationMyUserRequest;
import com.retailer.user.dto.AuthenticationMyUserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Base64;
import java.util.List;
import java.util.Optional;

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
                    .role(Role.USER)
                    .build();
            Optional<MyAppUser> validateUserEmail = getUserByUserEmail(request.getUserEmail());
//           if(!validateUserEmail.isPresent()) {
               userRepository.save(myAppUser1);
               String responseToken = jwtService.getToken(myAppUser1);
               return AuthenticationMyUserResponse.builder()
                       .userName(validateUserEmail.get().getUsername())
                       .userEmail(myAppUser1.getUserEmail())
                       .message("User Saved successfully and token received")
                       .token(responseToken)
                       .build();
//           }else{
//               return AuthenticationMyUserResponse.builder()
//                       .userEmail(myAppUser1.getUserEmail())
//                       .message("EMail already exists")
//                       .build();
//           }
        }catch (BadCredentialsException e){
            return AuthenticationMyUserResponse.builder()
                    .message("Invalid credentials").build();
        }
    }

    @Override
    public AuthenticationMyUserResponse authenticate(AuthenticationRequest request) {
        System.err.println("Email=: "+ request.getUserEmail() +" pwd=: "+ request.getUserEmail());
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUserEmail(),
                        request.getUserPassword())
        );

        MyAppUser user = userRepository.findByUserEmail(request.getUserEmail()).orElseThrow();
        System.err.println("match"+ user.getUserEmail());
        String userPassword = user.getUserPassword();
        Base64.Decoder decoder = Base64.getUrlDecoder();
        String userInfoPwd = new String(decoder.decode(userPassword));
        System.err.println("userInfo= "+userInfoPwd);
        System.err.println("both email/password match");
         String responseToken = jwtService.getToken(user);
        return AuthenticationMyUserResponse.builder()
                .token(responseToken)
                .build();
    }
    @Override
    public List<MyAppUser> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public Optional<MyAppUser> getUserByUserEmail(String userEmail) {
        return userRepository.findByUserEmail(userEmail);
    }
}