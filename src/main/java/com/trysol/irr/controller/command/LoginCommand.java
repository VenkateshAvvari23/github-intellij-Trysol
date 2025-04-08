package com.trysol.irr.controller.command;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginCommand {

    private String username;

    private String password;

}
