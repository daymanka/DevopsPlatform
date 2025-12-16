package com.devops.platform.services;

import org.springframework.stereotype.Service;

import com.devops.platform.repository.UserRepository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import com.devops.platform.dto.*;
import com.devops.platform.models.*;
import java.util.List;

@Service
@AllArgsConstructor

@Getter @Setter
public class UserService {
    private final UserRepository userRepository;
    
    public UserDto create(CreateUserRequest userRequest){

        User user = new User (
            userRequest.getUsername(),
            userRequest.getEmail(),
            userRequest.getPassword()
        );
        return toDto(userRepository.save(user)); 
    }

    public List<UserDto> findAll(){
        return userRepository.findAll().stream().map(this::toDto).toList();
    }

    private UserDto toDto(User user) {
        UserDto dto = new UserDto();
        dto.username = user.getUsername();
        dto.email = user.getEmail();
        return dto;
    }
    
}
