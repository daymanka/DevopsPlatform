package com.devops.platform.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devops.platform.dto.CreateUserRequest;
import com.devops.platform.dto.UserDto;
import com.devops.platform.services.UserService;

import lombok.AllArgsConstructor;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {
    private UserService userService;


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserDto create(@RequestBody CreateUserRequest request){
        return userService.create(request);
    }

    @GetMapping()
    public List<UserDto> findAll(){
        return userService.findAll();
    }


}
