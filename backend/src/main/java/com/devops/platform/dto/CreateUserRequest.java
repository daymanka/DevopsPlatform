package com.devops.platform.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter

public class CreateUserRequest {

    public String username;
    public String email;
    public String password;
}
