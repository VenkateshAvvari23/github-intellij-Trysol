package com.trysol.irr.controller.command;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RegisterCommand {


    @NotBlank(message = "Username must not be blank")
//    @Size(min = 3, max = 10, message = "Username must be between 5 and 20 characters")
//    @Pattern(regexp = "^[a-zA-Z]+$", message = "Username must contain only alphabets")
//    @Pattern(regexp = "^[^\\s]+$", message = "Username cannot contain spaces")
    private String username;

    @NotBlank(message = "Email must not be blank")
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@gmail\\.com$", message = "Email must be a valid Gmail address")
    private String email;

    private String phone;

    private String password;

    private String confirmPassword;


}
