package com.snmhecom.service;

import org.springframework.http.ResponseEntity;

import com.snmhecom.entities.User;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface IuserService {

    User addUser(User user);
    List<User> getAllUsers();
    Optional<User> getUserById(Long id);
    User getUserById1(Long id) throws Exception;
    void deleteUser(Long id);
    ResponseEntity<User> updateUser(Long id,User user) throws Exception;
     Map<String, Boolean> deleteUser1(Long userId) throws Exception;
     ResponseEntity<?> createUser(User user) ;
     User getSearchUserEmail(String email) ;
     List<User> getSearchUserMobile(Long mobile) ;





}
