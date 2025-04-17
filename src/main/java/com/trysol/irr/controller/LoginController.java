package com.trysol.irr.controller;


import com.trysol.irr.Exception.InvalidCredentialsException;
import com.trysol.irr.Exception.UserAlreadyExistsException;
import com.trysol.irr.Exception.UserNotFound;
import com.trysol.irr.controller.command.LoginCommand;
import com.trysol.irr.controller.command.RegisterCommand;
import com.trysol.irr.Exception.IllegalArgumentException;
import com.trysol.irr.dto.UserDto;
import com.trysol.irr.entity.User;
import com.trysol.irr.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody LoginCommand loginCommand) throws InvalidCredentialsException {

        return new ResponseEntity<UserDto>(userService.login(loginCommand),HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@Valid @RequestBody RegisterCommand registerCommand)throws UserAlreadyExistsException,IllegalArgumentException {

      String response = userService.register(registerCommand);

        return new ResponseEntity<>(response,HttpStatus.CREATED);

    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() throws UserAlreadyExistsException {

        List<User> users = userService.getAllUsers();

        if (users.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id)throws UserNotFound {

        String response = userService.deleteId(id);
       return new ResponseEntity<>(response,HttpStatus.OK);


       }


//    @PutMapping("/update/{id}")
//    public ResponseEntity<String> update(@PathVariable long id, RegisterCommand registerCommand){
//
//
//        userService.update(id,registerCommand);
//
//        return null;
//    }

    @PostMapping("/forgotPassword")
    public ResponseEntity<String> forgotPassword(@RequestBody RegisterCommand registerCommand){


      String response = userService.forgotPassword(registerCommand);

        return new  ResponseEntity<>(response,HttpStatus.OK);
    }

}
