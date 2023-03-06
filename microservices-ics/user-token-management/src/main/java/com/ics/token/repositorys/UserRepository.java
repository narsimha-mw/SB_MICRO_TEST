package com.ics.token.repositorys;

import com.ics.token.models.MyAppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<MyAppUser, Integer> {

    Optional<MyAppUser> findByUserEmail(String userEmail);
}
