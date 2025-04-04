package com.trysol.irr.service.impl;

import com.trysol.irr.Exception.InvalidCredentialsException;
import com.trysol.irr.controller.command.LoginCommand;
import com.trysol.irr.dto.UserDto;
import com.trysol.irr.repository.UserRepository;
import com.trysol.irr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDto login(LoginCommand loginCommand) throws InvalidCredentialsException{

        if(loginCommand.getUsername().equals("Test")&&loginCommand.getPassword().equals("password")){

           return new UserDto(loginCommand.getUsername(), loginCommand.getPassword());
        }
        else{

             throw new InvalidCredentialsException("Invalid username or password");
        }

    }
}
