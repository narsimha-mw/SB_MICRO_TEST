package com.retailer.user.service;

import com.retailer.user.model.UserLogin;
import com.retailer.user.repository.UserLoginRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserLoginServiceImpl implements UserLoginService {

    @Autowired
    private UserLoginRepository userLoginRepository;
    @Override
    public UserLogin createUser(UserLogin user) {
        String plainPwd = user.getUserPassword();
        // work factor of bcrypt
//        int strength = 10;
//        BCryptPasswordEncoder bCryptPwdEncoder = new BCryptPasswordEncoder(strength, new SecureRandom());
//        String encodedPassword = bCryptPwdEncoder.encode(plainPwd);
//        user.setUserPassword(encodedPassword);
        return userLoginRepository.save(user);
    }

    @Override
    public List<UserLogin> getUserDetails() {
        return userLoginRepository.findAll();
    }

    @Override
    public Optional<UserLogin> getUser(Integer userId) {
        return userLoginRepository.findById(userId);
    }

}
