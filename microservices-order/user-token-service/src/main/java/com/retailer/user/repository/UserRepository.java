package com.retailer.user.repository;

import com.retailer.user.model.MyAppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<MyAppUser, Integer> {

    Optional<MyAppUser> findByUserEmail(String userEmail);
}
