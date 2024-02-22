package com.snmhecom.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;

import com.snmhecom.entities.User;
import com.snmhecom.repository.userRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@Service
public class ImpluserService implements IuserService{

 //   PasswordEncoder encoder;

    @Autowired
    userRepository urepos;

    @Override
    public User addUser(User user) {
        return urepos.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return urepos.findAll();
    }

    @Override
    public Optional<User> getUserById(Long id){

        return urepos.findById(id);
    }

    @Override
    public User getUserById1(Long id) throws Exception {

        return urepos.findById(id)
                .orElseThrow(() -> new Exception("Utilisateur non trouvé pour cet id: " + id));
    }


    @Override
    public void deleteUser(Long id){
        urepos.deleteById(id);

    }

    @Override
    public Map<String, Boolean> deleteUser1(Long userId) throws Exception {
        User user = urepos.findById(userId)
                .orElseThrow(() -> new Exception("Utilisateur non trouvé pour cet id:: " + userId));
        urepos.delete(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("supprimé", Boolean.TRUE);
        return response;
    }

    @Override
    public ResponseEntity<User> updateUser(Long id,User user) throws Exception {

        User user1 = urepos.findById(id)
                .orElseThrow(() -> new Exception("Utilisateur non trouvé pour cet id: " + id));;

        if(user.getEmail() != null && !user.getEmail().isEmpty()) user1.setEmail(user.getEmail());
        if(user.getFamily_name() != null && !user.getFamily_name().isEmpty()) user1.setFamily_name((user.getFamily_name()));
        if(user.getFirst_name() != null && !user.getFirst_name().isEmpty()) user1.setFirst_name(user.getFirst_name());
        if(user.getMobile() != null && user.getMobile()!=0)  user1.setMobile(user.getMobile());
        user1.setRole(user.getRole());
        if(user.getPassword() != null && !user.getPassword().isEmpty()) user1.setPassword(user.getPassword());

        final User updatedUser = urepos.save(user1);
        return ResponseEntity.ok(updatedUser);
    }

    public ResponseEntity<?> createUser( User user) {

        if (urepos.existsByEmail(user.getEmail())) {
            return ResponseEntity.badRequest().body(" Email existe déja!"); }

        User user1 = new User(user.getEmail(), user.getPassword(), user.getMobile(),
                user.getFirst_name(), user.getFamily_name());
        System.out.println("+++++++"+user1);
        urepos.save(user1);

        return ResponseEntity.ok("utilisateur enregistré avec succée!");
    }

    public User getSearchUserEmail(String email) {
        return urepos.findUserByEmail(email);
    }

    public List<User> getSearchUserMobile(Long mobile) {
        return urepos.findUserByMobile(mobile);
    }

}

