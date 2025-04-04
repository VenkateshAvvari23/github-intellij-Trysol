package com.trysol.irr.service;



import com.trysol.irr.Exception.InvalidCredentialsException;
import com.trysol.irr.controller.command.LoginCommand;
import com.trysol.irr.dto.UserDto;

public interface UserService {

    public UserDto login(LoginCommand loginCommand) throws InvalidCredentialsException;
}
