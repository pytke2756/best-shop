package com.shop.best.shop.controller;

import com.shop.best.shop.model.User;
import com.shop.best.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api/v1/users")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping()
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getSpecificUser(@PathVariable(value = "id") Integer id) {
        Optional<User> userOptional = userService.getSpecificUser(id);
        if (userOptional.isPresent()) {
            return new ResponseEntity<>(userOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @PostMapping()
    // with repository
    public void registerNewUser(@RequestBody User user) {
        userService.addNewUser(user);
    }

    @PatchMapping("/{id}")
    public void patchSpecificUser(@PathVariable("id") Integer id, @RequestBody User user) {
        userService.updateUser(id, user);
    }

    /*
     * ha postolok és nem sikeres attól emeli az id-t
     * */
    @PostMapping("/resentity")
    // with reponseentity
    public ResponseEntity<User> registerNewUserWithoutRepo(@RequestBody User user) {
        if (user.getFirstName() == null) {
            return new ResponseEntity<>(user, HttpStatus.CONFLICT);
        }
        if (user.getId() != null) {
            return new ResponseEntity<>(user, HttpStatus.CONFLICT);
        }
        userService.addNewUser(user);
        return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
    }
}
