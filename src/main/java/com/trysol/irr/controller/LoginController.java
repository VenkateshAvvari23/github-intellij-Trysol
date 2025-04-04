package com.trysol.irr.controller;


import com.trysol.irr.Exception.InvalidCredentialsException;
import com.trysol.irr.controller.command.LoginCommand;
import com.trysol.irr.dto.UserDto;
import com.trysol.irr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody LoginCommand loginCommand) throws InvalidCredentialsException {

        return new ResponseEntity<UserDto>(userService.login(loginCommand),HttpStatus.CREATED);
    }

}
