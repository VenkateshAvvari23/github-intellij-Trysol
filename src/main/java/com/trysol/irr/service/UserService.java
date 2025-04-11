package com.trysol.irr.service;



import com.trysol.irr.Exception.IllegalArgumentException;
import com.trysol.irr.Exception.InvalidCredentialsException;
import com.trysol.irr.Exception.UserAlreadyExistsException;
import com.trysol.irr.Exception.UserNotFound;
import com.trysol.irr.controller.command.LoginCommand;
import com.trysol.irr.controller.command.RegisterCommand;
import com.trysol.irr.dto.UserDto;
import com.trysol.irr.entity.User;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;


public interface UserService {

    public UserDto login(LoginCommand loginCommand) throws InvalidCredentialsException;

    public String register(RegisterCommand registerCommand) throws UserAlreadyExistsException, IllegalArgumentException;
    //public UserDto register(RegisterCommand registerCommand);

    public List<User> getAllUsers();

    public String deleteId(Long id)throws UserNotFound;

    public User update(Long id, RegisterCommand registerCommand);

    public String forgotPassword(RegisterCommand registerCommand)throws UserNotFound;
}
