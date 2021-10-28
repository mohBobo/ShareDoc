package com.bobo.bibliotheque.controller;

import com.bobo.bibliotheque.entities.User;
import com.bobo.bibliotheque.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @PostMapping("/users")
    public ResponseEntity add(@Valid @RequestBody User user, HttpServletResponse response) {


        List<User> users = userRepository.findByEmail(user.getEmail());
        if(!users.isEmpty()) {
            return new ResponseEntity("User already existing", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(user, HttpStatus.CREATED);
    }

}
