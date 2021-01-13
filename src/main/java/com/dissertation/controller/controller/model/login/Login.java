package com.dissertation.controller.controller.model.login;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Login {

    private Long id;
    @NotEmpty(message = "Username/Email is required")
    private String username;
    @NotEmpty(message = "Password is required")
    private String password;
}
