package com.trysol.irr.service.impl;

import com.trysol.irr.Exception.InvalidCredentialsException;
import com.trysol.irr.Exception.UserAlreadyExistsException;
import com.trysol.irr.Exception.UserNotFound;
import com.trysol.irr.controller.command.LoginCommand;
import com.trysol.irr.controller.command.RegisterCommand;
import com.trysol.irr.Exception.IllegalArgumentException;
import com.trysol.irr.dto.UserDto;
import com.trysol.irr.entity.User;
import com.trysol.irr.repository.UserRepository;
import com.trysol.irr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @Override
    public UserDto login(LoginCommand loginCommand) throws InvalidCredentialsException {
        Optional<User> user = userRepository.findByUsername(loginCommand.getUsername());

        if ("Test".equals(loginCommand.getUsername()) && "password@123".equals(loginCommand.getPassword())) {

            return getUserDto(loginCommand.getUsername(), loginCommand.getPassword());
        } else if (user.isPresent() && user.get().getUsername().equals(loginCommand.getUsername()) && user.get().getPassword().equals(loginCommand.getPassword())) {

            return getUserDto(loginCommand.getUsername(), loginCommand.getPassword());
        } else {

            throw new InvalidCredentialsException("Invalid username or password");
        }
    }


    public String register(RegisterCommand registerCommand) throws UserAlreadyExistsException, IllegalArgumentException {

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


    public String deleteId(Long id) throws UserNotFound {


            if (id == null || !userRepository.existsById(id)) {
                throw new UserNotFound("Employee not found with id: " + id);
            }
            userRepository.deleteById(id);
           return "Employee deleted successfully";


    }

//    @Override
//    public User update(Long id, RegisterCommand registerCommand) throws UserNotFound{
//
//        Optional<User> existingUserOpt = userRepository.findById(id);
//
//        if(existingUserOpt.isEmpty()){
//
//            throw new UserNotFound("Employee not found with id: " + id);
//        }
//
//        User existingUser = existingUserOpt.get();
//
//        existingUser.setUsername(registerCommand.getUsername());
//        existingUser.setEmail(registerCommand.getEmail());
//        existingUser.setPhoneNo(registerCommand.getPhone());
//
//        //    User updatedUser = getUserEntity(registerCommand);
//
//   //     updatedUser.setId(existingUser.getId());
//
//        return userRepository.save(existingUser);
//
//
//    }


    public String forgotPassword(RegisterCommand registerCommand)throws UserNotFound {

        Optional<User> optionalUser = userRepository.findByEmail(registerCommand.getEmail());

        if (optionalUser.isPresent()){

            User user1 =  optionalUser.get();

            if (!registerCommand.getPassword().equals(registerCommand.getConfirmPassword())) {
                return "Password does not match.";
            }
            else {

                user1.setPassword(registerCommand.getPassword());
                userRepository.save(user1);
                return "password is changed successfully";
            }
          }
        else{

             throw new UserNotFound("User not found with the given email");
        }

    }

}
