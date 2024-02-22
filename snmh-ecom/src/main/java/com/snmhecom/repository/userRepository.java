package com.snmhecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.snmhecom.entities.User;

import java.util.List;

@Repository
public interface userRepository extends JpaRepository<User,Long> {
    Boolean existsByEmail(String email);
    User findUserByEmail(String email);
    List<User> findUserByMobile(Long mobile);


}
