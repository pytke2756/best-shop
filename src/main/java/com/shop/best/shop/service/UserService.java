package com.shop.best.shop.service;

import com.shop.best.shop.model.User;
import com.shop.best.shop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public List<User> getUsers() {
        return userRepository.findAll();
    }


    //with repository
    public void addNewUser(User user) {
        userRepository.save(user);
    }


    public Optional<User> getSpecificUser(Integer id) {
        return userRepository.findById(id);
    }

    //saját ötlet, új idval hozza létre :(
    /*@Transactional
    public ResponseEntity<User> updateUser(Integer id, User user) {
        Optional<User> u = userRepository.findById(id);
        if (u.isEmpty()){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        User tempUser = u.get();
        tempUser = user;
        userRepository.save(tempUser);
        return new ResponseEntity<>(tempUser, HttpStatus.ACCEPTED);
    }*/

    @Transactional
    public ResponseEntity<User> updateUser(Integer id, User user) {
        int updatedRows = userRepository.updateUserData(id,
                user.getFirstName(),
                user.getLastName(),
                user.getRegistrationDate(),
                user.getStreet()
        );

        if (updatedRows == 0) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
