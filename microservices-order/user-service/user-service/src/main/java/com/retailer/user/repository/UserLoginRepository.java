package com.retailer.user.repository;

import com.retailer.user.model.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLoginRepository extends JpaRepository<UserLogin, Integer> {
    UserLogin findByUserEmail(String email);

}
