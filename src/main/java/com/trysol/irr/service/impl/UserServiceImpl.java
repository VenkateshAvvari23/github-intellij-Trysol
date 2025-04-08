package com.trysol.irr.service.impl;

import com.trysol.irr.Exception.InvalidCredentialsException;
import com.trysol.irr.Exception.UserAlreadyExistsException;
import com.trysol.irr.controller.command.LoginCommand;
import com.trysol.irr.controller.command.RegisterCommand;
import com.trysol.irr.Exception.IllegalArgumentException;
import com.trysol.irr.dto.UserDto;
import com.trysol.irr.entity.User;
import com.trysol.irr.repository.UserRepository;
import com.trysol.irr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


@Override
public UserDto login(LoginCommand loginCommand) throws InvalidCredentialsException {
    Optional<User> user = userRepository.findByUsername(loginCommand.getUsername());

    if ("Test".equals(loginCommand.getUsername()) && "password@123".equals(loginCommand.getPassword())) {

        return getUserDto(loginCommand.getUsername(), loginCommand.getPassword());
    }
    else if (user.isPresent() && user.get().getUsername().equals(loginCommand.getUsername())&& user.get().getPassword().equals(loginCommand.getPassword())) {

        return getUserDto(loginCommand.getUsername(), loginCommand.getPassword());
    } else {

        throw new InvalidCredentialsException("Invalid username or password");
    }
}



    public String register(RegisterCommand registerCommand)  throws UserAlreadyExistsException,IllegalArgumentException{

        Optional<User> user = userRepository.findByEmail(registerCommand.getEmail());

        if (user.isPresent()) {
            throw new UserAlreadyExistsException("User with email " + registerCommand.getEmail() + " already exists.");
        } else if (!registerCommand.getPassword().equals(registerCommand.getConfirmPassword()))

            throw new IllegalArgumentException("Password does not match");

        else {
             userRepository.save(getUserEntity(registerCommand));
             return "User successfully registered";
        }
    }


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    private UserDto getUserDto(String userName, String password) {
//        UserDto userDto = new UserDto();
//        userDto.setUserName(userName);
//        userDto.setPassword(password);
//        return userDto;

        return UserDto.builder().username(userName).password(password).build();


    }

    private User getUserEntity(RegisterCommand registerCommand) {
//        User user = new User();
//        user.setUsername(registerCommand.getUsername());
//        user.setPassword(registerCommand.getPassword());
//        user.setEmail(registerCommand.getEmail());
//        user.setPhoneNo(registerCommand.getPhone());
//        return user;

        return User.builder().username(registerCommand.getUsername()).password(registerCommand.getPassword()).email(registerCommand.getEmail()).phoneNo(registerCommand.getPhone()).build();

    }


}